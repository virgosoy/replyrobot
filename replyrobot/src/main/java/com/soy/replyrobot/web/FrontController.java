package com.soy.replyrobot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soy.replyrobot.service.CommandService;
import com.soy.replyrobot.util.Constants;
import com.soy.replyrobot.util.StringUtils;

@Controller
public class FrontController {
	
	@Autowired
	private CommandService commandService;
	
	@RequestMapping("/talk")
	public String talk(){
		return "front/talk";
	}
	
	/**
	 * <p>发送消息到公众号，公众号自动回复</p>
	 * @author zhengsiyou
	 * @return 
	 */
	@RequestMapping("/autoReply")
	@ResponseBody
	public String autoReply(String content){
		return commandService.autoReply(content);
	}
	
}
