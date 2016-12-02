package com.soy.replyrobot.service.baidumap;

import java.io.IOException;

import org.junit.Test;

import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.CallbackType;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Coding;
import com.soy.replyrobot.service.baidumap.tool.DefaultHttpTool;
import com.soy.replyrobot.service.baidumap.tool.HttpTool;
import com.soy.replyrobot.service.baidumap.tool.ParseParamTool;
import com.soy.replyrobot.service.baidumap.tool.ParseParamToolFactory;

public class TestClass {
	static String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";

//	@Test
	public void test(){
		String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";
		ParseParamTool tool = ParseParamToolFactory.create(ak);
		HighacciplocParam param = new HighacciplocParam();
		param.setCoding(Coding.GBK);
		System.out.println(tool.parse(param));
	}
	
//	@Test 
	public void http() throws IOException{
		String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";
		HttpTool httpTool = new DefaultHttpTool(); 
		String str = httpTool.connect("http://api.map.baidu.com/place/v2/search?q=饭店&region=北京&output=json&ak="+ak);
		System.out.println(str);
	}

	@Test
	public void test3(){
		BaiduMapApi baiduMapApi = new BaiduMapApiImpl(ak);
		HighacciplocParam param = new HighacciplocParam();
		param.setCallback_type(CallbackType.JSONP);
		System.out.println(baiduMapApi.highacciploc(param));
	}
}
