package com.soy.replyrobot.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Http工具类</p>
 * @author zhengsiyou
 * @version 0.2
 */
public class HttpUtils {

	/**
	 * <p>为url设置参数</p>
	 * <p>不改动其他原有参数，若设置的参数存在，则覆盖。</p>
	 * <p>方法名：setParam</p>
	 * @author zhengsiyou
	 * @date 2016年3月21日-上午9:35:15
	 * @param paramName
	 * @param value
	 * @param url
	 * @return 
	 * 返回类型：String
	 * @since 0.1
	*/
	public static String setParam(String paramName,Object value,String url){
		return setParam(paramName, value, url, true);
		/*//原方法：
		assert paramName!=null && value!=null && url!=null;
		if(url.matches(".*[&?]"+paramName+"=.*")){ //存在此参数
			url = url.replaceAll("(?<=[&?]"+paramName+"=)\\d+", String.valueOf(value));
		}else{
			if(url.indexOf('?')==-1){
				url = url.concat("?");
			}
			url = url.concat("&"+paramName+"="+value);
		}
		return url;*/
	}
	
	/**
	 * <p>为url设置参数</p>
	 * <p>不改动其他原有参数，若设置的参数存在，则根据设置进行覆盖或不操作。</p>
	 * @author zhengsiyou
	 * @date 2016年12月5日-上午11:31:55
	 * @param paramName
	 * @param value
	 * @param url
	 * @param canReplace 存在相同的参数时，是否覆盖。
	 * @return 
	 * @since 0.2
	 */
	public static String setParam(String paramName,Object value,String url,boolean canReplace){
		assert paramName!=null && value!=null && url!=null;
		if(url.matches(".*[&?]"+paramName+"=.*")){ //存在此参数
			if(canReplace){ //是否可以覆盖
				url = url.replaceAll("(?<=[&?]"+paramName+"=)\\d+", String.valueOf(value));
			}else{
				//不对url进行操作。
				return url;
			}
		}else{
			if(url.indexOf('?')==-1){
				url = url.concat("?");
			}
			url = url.concat("&"+paramName+"="+value);
		}
		return url;
	}
	

	/**
	 * <p>为url添加多个参数</p>
	 * <p>不改动其他原有参数，若设置的参数存在，则覆盖。</p>
	 * @author zhengsiyou
	 * @date 2016年12月5日-上午11:17:54
	 * @param params 参数列表
	 * @param url 原有url
	 * @return 新的url
	 * @since 0.2
	 */
	public static String setParams(Map<String,Object> params,String url){
		assert params!=null && url!=null;
		for(Entry<String, Object> entry : params.entrySet()){
			url = setParam(entry.getKey(),entry.getValue(),url);
		}
		return url;
	}
	
	/**
	 * <p>根据url获取指定参数值</p>
	 * <p>方法名：getParam</p>
	 * @author zhengsiyou
	 * @date 2016年3月21日-下午2:39:27
	 * @param paramName
	 * @param url
	 * @return 
	 * 返回类型：String
	 * @since 0.1
	*/
	public static String getParam(String paramName,String url){
		assert paramName!=null && url!=null;
		Pattern p = Pattern.compile("(?<=[?&]"+paramName+"=)[.[^&]]*");
		Matcher m = p.matcher(url);
		if(m.find()){
			return m.group();
		}else{
			return null;
		}
	}

}
