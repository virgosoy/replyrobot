package com.soy.replyrobot.service.logic;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soy.replyrobot.service.baidumap.BaiduMapApi;
import com.soy.replyrobot.service.baidumap.DefaultBaiduMapApi;
import com.soy.replyrobot.service.baidumap.param.GeocoderParam;
import com.soy.replyrobot.service.baidumap.param.GeocoderParam.Output;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Coord;
import com.soy.replyrobot.service.baidumap.param.HighacciplocParam.Qterm;
import com.soy.replyrobot.service.baidumap.param.Location;
import com.soy.replyrobot.service.logic.anno.Command;

/**
 * <p>此类用于将指令与执行方法绑定</p>
 * <p>在此类中声明的要与指令绑定的方法都为public String methodName()的签名格式，
 * 且需注解{@link Command}，
 * 返回值为执行此指令的返回结果。</p>
 * @author zhengsiyou
 */
@Service
public class CommandMethod {

	public static Map<String,Method> methodMap = new HashMap<>();
	public static Map<String,String> methodDescriptionMap = new HashMap<>();
	
	static{
		Method[] methods = CommandMethod.class.getMethods();
		for (Method method : methods) {
			Command anno = method.getAnnotation(Command.class);
			if(anno!=null){
				methodMap.put(anno.value(),method);
				if(!anno.description().equals("")){
					methodDescriptionMap.put(anno.value(), anno.description());
				}
			}
		}
	}
	
	
	private final static String ak = "RiiKh6SjFTWsF3aQ5T1Nk4bDADyRE6aI";
	
	/**
	 * <p>获得我的位置</p>
	 * @author zhengsiyou
	 * @return 
	 */
	@Command(value="我的位置",description="我的位置")
	public String location(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		BaiduMapApi baiduMapApi = new DefaultBaiduMapApi(ak);
		HighacciplocParam highacciplocParam = new HighacciplocParam();
		highacciplocParam.setQterm(Qterm.PC);
		highacciplocParam.setQcip(request.getRemoteAddr());
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
			return "定位失败";
		}
		GeocoderParam geocoderParam = new GeocoderParam();
		geocoderParam.setOutput(Output.JSON);
		geocoderParam.setLocation(location);
		jsonString = baiduMapApi.geocoder(geocoderParam);
		System.out.println(jsonString);
		json = JSON.parseObject(jsonString);
		if(json.getIntValue("status")==0){
			return "您的位置是："+json.getJSONObject("result").getString("formatted_address");
		}else{
			return "定位失败";
		}
	}
}
