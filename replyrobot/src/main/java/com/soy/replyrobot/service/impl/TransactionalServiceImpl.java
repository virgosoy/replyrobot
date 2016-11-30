package com.soy.replyrobot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soy.replyrobot.dao.CommandDao;
import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.service.TransactionalService;

@Service
//@Transactional
public class TransactionalServiceImpl implements TransactionalService {

	@Autowired
	private CommandDao commandDao;
	
	@Override
	@Transactional
	public void transactionalOpeation() {
		Command command1 = new Command();
		command1.setCommand("命令1");
		Command command2 = new Command();
		command2.setCommand("命令2");
		commandDao.addCommand(command1);
		int i = 1 / 0;
		commandDao.addCommand(command2);
	}

}
