package com.soy.replyrobot.service.baidumap;

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
}
