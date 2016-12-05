package com.soy.replyrobot.test;

import java.io.IOException;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soy.replyrobot.service.baidumap.BaiduMapApi;
import com.soy.replyrobot.service.baidumap.DefaultBaiduMapApi;
import com.soy.replyrobot.service.baidumap.param.GeocoderParam;
import com.soy.replyrobot.service.baidumap.param.GeocoderParam.Output;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Coding;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Coord;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Qterm;
import com.soy.replyrobot.service.baidumap.param.Location;
import com.soy.replyrobot.service.baidumap.paramtool.ParseParamTool;
import com.soy.replyrobot.service.baidumap.paramtool.ParseParamToolFactory;
import com.soy.replyrobot.service.baidumap.tool.DefaultHttpTool;
import com.soy.replyrobot.service.baidumap.tool.HttpTool;

public class BaiduMapApiTest {
	static String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";

//	@Test
	public void test(){
		String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";
		ParseParamTool tool = ParseParamToolFactory.create();
		tool.setAk(ak);
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

//	@Test
	//百度API基本测试
	public void test3(){
		BaiduMapApi baiduMapApi = new DefaultBaiduMapApi(ak);
		HighacciplocParam highacciplocParam = new HighacciplocParam();
		highacciplocParam.setQterm(Qterm.PC);
		highacciplocParam.setQcip("115.174.80.130");
		highacciplocParam.setCoord(Coord.BAIDU_LL);
		System.out.println(baiduMapApi.highacciploc(highacciplocParam));
		
		GeocoderParam geocoderParam = new GeocoderParam();
		geocoderParam.setOutput(Output.JSON);
		geocoderParam.setLocation(new Location(22.754772,113.847417));
		System.out.println(new Location(39.983424,116.322987));
		System.out.println(baiduMapApi.geocoder(geocoderParam));
	}
	
	@Test
	public void test4(){
		BaiduMapApi baiduMapApi = new DefaultBaiduMapApi(ak);
		HighacciplocParam highacciplocParam = new HighacciplocParam();
		highacciplocParam.setQterm(Qterm.PC);
		highacciplocParam.setQcip("115.174.80.130");
		highacciplocParam.setCoord(Coord.BAIDU_LL);
		String jsonString = baiduMapApi.highacciploc(highacciplocParam);
		
		JSONObject json = JSON.parseObject(jsonString);
		Location location = null;
		if(json.getJSONObject("result").getIntValue("error")==161){
			//定位成功
			//获取位置
			location = json.getJSONObject("content").getObject("location", Location.class);
		}else{
			System.err.println("定位失败");
			return;
		}
		GeocoderParam geocoderParam = new GeocoderParam();
		geocoderParam.setOutput(Output.JSON);
		geocoderParam.setLocation(location);
		jsonString = baiduMapApi.geocoder(geocoderParam);
		System.out.println(jsonString);
		json = JSON.parseObject(jsonString);
		if(json.getIntValue("status")==0){
			System.out.println(json.getJSONObject("result").getString("formatted_address"));
		}
		
	}
}
