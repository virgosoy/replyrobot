package com.soy.replyrobot.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.service.CommandService;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@Autowired
	private CommandService commandService;
	
	@RequestMapping("/command")
	public ResponseEntity<Command> getCommand(@RequestParam("command") String commandName){
		Command result = commandService.queryFullCommandByName(commandName);
		//如果结果为null，那么返回一个new Command()
		Optional<Command> optional = Optional.ofNullable(result);
		return new ResponseEntity<>(optional.orElse(new Command()),HttpStatus.OK);
//		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	
}
