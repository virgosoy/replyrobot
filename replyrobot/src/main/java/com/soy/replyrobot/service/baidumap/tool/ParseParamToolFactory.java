package com.soy.replyrobot.service.baidumap.tool;

/**
 * @author zhengsiyou
 */
//简单工厂模式
public final class ParseParamToolFactory {
	
	private ParseParamToolFactory(){};
	
	public static ParseParamTool create(){
		return new DefaultParseParamTool();
	}
	
	public static ParseParamTool create(String ak){
		return new DefaultParseParamTool(ak);
	}
	
}
