package com.soy.replyrobot.service.baidumap.tool;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.soy.replyrobot.service.baidumap.param.BaiduApiParam;
import com.soy.replyrobot.service.baidumap.param.Required;

public class DefaultParseParamTool implements ParseParamTool {
	
	/**
	 * 开发者密钥
	 * @since
	 */
	private String ak;
	public DefaultParseParamTool(){};
	public DefaultParseParamTool(String ak){
		this.ak = ak;
	};
	
	@Override
	public String parse(BaiduApiParam param) {
		try {
			Map<String,String> map = introspector(param);
			testRequired(param,map);
			return dealStringParam(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * <p>内省</p>
	 * @author zhengsiyou
	 * @param clazz 
	 * @param param 
	 * @return 
	 * @throws Exception 
	 */
	private Map<String,String> introspector(BaiduApiParam param) throws Exception{
		Class<? extends BaiduApiParam> clazz = param.getClass();
		
		//参数列表
		Map<String,String> map = new HashMap<String, String>();
		
		//JavaBean内省
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String property = propertyDescriptor.getName();
			if("class".equals(property)){
				//不解析getClass();
				continue;
			}
			
			//获取结果
			Method readMethod = propertyDescriptor.getReadMethod();
			Object result = readMethod.invoke(param);
			
			//如果是ak字段，且此字段没值，有全局ak。
			if("ak".equals(property) && result==null && ak!=null){
				//则结果设为全局ak，但是参数不会注入。
				result = ak;
			}
			
			if(result!=null){
				map.put(property, result.toString());
			}
		}
		return map;
	}
	
	/**
	 * <p>处理map拼接成url参数</p>
	 * @author zhengsiyou
	 * @param map
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	private String dealStringParam(Map<String,String> map) throws UnsupportedEncodingException{
		StringBuilder sb = new StringBuilder(); //存储拼接字符串
		//拼接结果
		for (Entry<String, String> e : map.entrySet()) {
			sb.append(e.getKey());
			sb.append('=');
			//编码成URLEncode。
			sb.append(URLEncoder.encode(e.getValue(), "utf-8"));
			sb.append('&');
		}
		//如果最后一个字符为'&'则删除它。
		if(sb.length()>0 && sb.charAt(sb.length()-1)=='&'){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	/**
	 * <p>检查注解</p>
	 * @author zhengsiyou
	 * @param clazz
	 * @param map
	 * @return 
	 */
	private void testRequired(BaiduApiParam param,Map<String,String> map){
		Class<? extends BaiduApiParam> clazz = param.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			//检查注解
			String property = field.getName();
			field.setAccessible(true);
			Required required = field.getAnnotation(Required.class);
			if(required!=null){ //如果有@Required注解 
				if(!required.relation().equals("")){ //如果有设置relation元素
					//获取对应的值
					String targetValue = map.get(required.relation());
					
					for(String sourceValue : required.relationValue()){
						if(sourceValue.equals(targetValue)){ //如果值符合
							//那么要求被注解元素要有值
							if(map.get(property)==null){
								throw new IllegalArgumentException(property+"属性不能为null");
							}
						}
					}
				}else if(required.value()==true){
					if(map.get(property)==null){
						throw new IllegalArgumentException(property+"属性不能为null");
					}
				}
			}
		}
	}
}
