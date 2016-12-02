package com.soy.replyrobot.service.baidumap.paramtool;

import com.soy.replyrobot.service.baidumap.param.BaiduApiParam;

/**
 * <p>解析参数工具</p>
 * @author zhengsiyou
 */
public interface ParseParamTool {
	
	/**
	 * <p>将参数模型解析成http参数</p>
	 * @author zhengsiyou
	 * @param param
	 * @return 
	 */
	String parse(BaiduApiParam param);
	
	/**
	 * <p>设置开发者密钥</p>
	 * @author zhengsiyou
	 * @param ak
	 */
	void setAk(String ak);
}
