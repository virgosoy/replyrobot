package com.soy.replyrobot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soy.replyrobot.service.TransactionalService;

@Controller
public class TestController {
	
	@Autowired
	private TransactionalService transactionalService;
	
	@RequestMapping("/test")
	public String test(){
		transactionalService.transactionalOpeation();
		return "test";
	}
}
