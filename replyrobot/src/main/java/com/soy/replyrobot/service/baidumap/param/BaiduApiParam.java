package com.soy.replyrobot.service.baidumap.param;

/**
 * <p>百度API参数基类</p>
 * @author zhengsiyou
 */
public abstract class BaiduApiParam {
	//开发者密钥
	protected String ak;

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}
	
}
