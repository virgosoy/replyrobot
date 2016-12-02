package com.soy.replyrobot.service.baidumap.paramtool;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.soy.replyrobot.service.baidumap.exception.BaiduApiException;
import com.soy.replyrobot.service.baidumap.param.BaiduApiParam;

/**
 * <p>抽象基类</p>
 * @author zhengsiyou
 * @data 2016年12月2日-下午5:58:45
 * @version 0.1
 */
//模版方法模式
public abstract class AbstractDefaultParseParamTool implements ParseParamTool {
	
	/**
	 * 开发者密钥
	 * @since
	 */
	private String ak;
	
	@Override
	//模版方法
	public final String parse(BaiduApiParam param) {
		try {
			//内省JavaBean获得参数列表
			Map<String,String> map = introspector(param);
			//检测必须参数
			if(isTestRequired()){
				testRequired(param,map);
			}
			//处理参数列表变成url参数字符串
			String result = dealStringParam(map);
			return result;
		} catch (Exception e) {
			throw new BaiduApiException("解析参数时出现错误",e);
		}
	}
	
	/**
	 * <p>钩子函数，是否执行检测</p>
	 * @author zhengsiyou
	 * @return 
	 */
	protected boolean isTestRequired(){
		return true;
	}
	
	/**
	 * <p>内省</p>
	 * @author zhengsiyou
	 * @param clazz 
	 * @param param 
	 * @return 
	 * @throws Exception 
	 */
	protected Map<String,String> introspector(BaiduApiParam param) throws Exception{
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
	protected String dealStringParam(Map<String,String> map) throws UnsupportedEncodingException{
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
	protected void testRequired(BaiduApiParam param,Map<String,String> map){
		Class<? extends BaiduApiParam> clazz = param.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			//检查注解
			String property = field.getName();
			field.setAccessible(true);
			Required required = field.getAnnotation(Required.class);
			if(required!=null){ //如果有@Required注解 
				String relationProp = required.relation();
				if(!relationProp.equals("")){ //如果有设置relation元素
					//获取对应的值
					String targetValue = map.get(relationProp); //无值会取得null
					//如果无值
					if(targetValue==null){
						targetValue = Required.EMPTY;
					}
					for(String sourceValue : required.relationValues()){
						if(sourceValue.equals(targetValue)){ //如果值符合
							//那么要求被注解元素要有值
							if(map.get(property)==null){
								if(targetValue!=Required.EMPTY){
									throw new IllegalArgumentException("当"+relationProp+"属性="+targetValue+"时，"+property+"属性不能为null");
								}else{
									throw new IllegalArgumentException(relationProp+" / "+property+" 属性不能为null");
								}
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
	
	@Override
	public void setAk(String ak) {
		this.ak = ak;
	}
}
