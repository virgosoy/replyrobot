package com.soy.replyrobot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	/**
	 * <p>ajax测试json接口页面</p>
	 * @author zhengsiyou
	 * @return 
	 */
	@RequestMapping("/ajax")
	public String ajax(){
		return "front/ajax";
	}
	
	/**
	 * <p>地图</p>
	 * @author zhengsiyou
	 * @return 
	 */
	@RequestMapping("/map")
	public String map(){
		return "front/map";
	}
}
