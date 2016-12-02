package com.soy.replyrobot.service.baidumap;

import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;

public interface BaiduMapApi {
	/**
	 * 高精度IP定位API
	 * @since
	 */
	static final String HIGHACCIPLOC_URL = "http://api.map.baidu.com/highacciploc/v1";
	
	/**
	 * <p>高精度IP定位API</p>
	 * @author zhengsiyou
	 * @return 
	 */
	String highacciploc(HighacciplocParam param);
	
}
