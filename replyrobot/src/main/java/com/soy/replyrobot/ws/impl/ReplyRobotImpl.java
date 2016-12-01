package com.soy.replyrobot.ws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soy.replyrobot.dao.CommandDao;
import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.service.CommandService;
import com.soy.replyrobot.ws.ReplyRobot;


@Service
public class ReplyRobotImpl implements ReplyRobot {

	@Autowired
	private CommandService commandService;
	@Autowired
	private CommandDao commandDao;
	
	@Override
	public String getContent(String command) {
		return commandService.autoReply(command);
	}

	@Override
	public Command getModel(String command) {
		return commandDao.queryFullCommandByName(command);
	}

}
