package com.soy.replyrobot.service.baidumap.paramtool;

/**
 * <p>解析参数工具类，不对参数进行测试</p>
 * @author zhengsiyou
 */
public class IgnoreTestParseParamTool extends AbstractDefaultParseParamTool {
	
	@Override
	protected boolean isTestRequired() {
		//关闭参数测试
		return false;
	}
}
