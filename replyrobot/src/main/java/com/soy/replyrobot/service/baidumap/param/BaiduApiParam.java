package com.soy.replyrobot.service.baidumap.param;

/**
 * <p>百度API参数基类</p>
 * @author zhengsiyou
 */
public abstract class BaiduApiParam {
	

	//开发者密钥
	private String ak;

	public String getAk() {
		return ak;
	}
	/**
	 * <p>开发者密钥</p>
	 * @author zhengsiyou
	 * @param ak 
	 */
	public void setAk(String ak) {
		this.ak = ak;
	}
	
	/**
	 * <p>api的url</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public abstract String apiUrl();
}
