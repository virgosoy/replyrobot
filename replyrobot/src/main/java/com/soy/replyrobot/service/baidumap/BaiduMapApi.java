package com.soy.replyrobot.service.baidumap;

import java.util.Map;

import com.soy.replyrobot.service.baidumap.param.GeocoderParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;

public interface BaiduMapApi {
	
	/**
	 * <p>高精度IP定位API</p>
	 * @author zhengsiyou
	 * @return 
	 */
	String highacciploc(HighacciplocParam param);
	
	/**
	 * <p>地址与经纬度坐标转换API</p>
	 * @author zhengsiyou
	 * @param param
	 * @return 
	 */
	String geocoder(GeocoderParam param);
	
	
	/**
	 * <p>执行web api</p>
	 * @author zhengsiyou
	 * @param fullUrl
	 * @return
	 */
	String execute(String fullUrl);
	
	/**
	 * <p>执行web api</p>
	 * @author zhengsiyou
	 * @param apiUrl
	 * @param params
	 * @return 
	 */
	String execute(String apiUrl,Map<String,Object> params);
}
