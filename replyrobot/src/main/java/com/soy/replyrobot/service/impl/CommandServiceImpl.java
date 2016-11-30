package com.soy.replyrobot.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.support.logging.Log;
import com.soy.replyrobot.dao.CommandContentDao;
import com.soy.replyrobot.dao.CommandDao;
import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.model.CommandContent;
import com.soy.replyrobot.service.CommandService;

@Service
public class CommandServiceImpl implements CommandService {
	private Logger logger = Logger.getLogger(CommandServiceImpl.class);

	@Autowired
	private CommandDao commandDao;
	@Autowired
	private CommandContentDao commandContentDao;
	
	@Override
	public List<Command> queryCommandList(Command command) {
		return commandDao.queryCommandList(command);
	}

	@Override
	public boolean addCommand(Command command) {
		return commandDao.addCommand(command);
	}

	@Override
	public int delete(Integer[] ids) {
		return commandDao.delete(ids);
	}

	@Override
	public Command queryFullCommandById(int id) {
		return commandDao.queryFullCommandById(id);
	}

	@Override
	@Transactional
	public boolean updateFullCommand(Command command) {
		commandDao.update(command);
		logger.debug(ReflectionToStringBuilder.toString(command));
		List<CommandContent> contentList = command.getContentList();
		List<CommandContent> insertList = new ArrayList<>();
		List<CommandContent> updateList = new ArrayList<>();
		List<Integer> existsIds = commandContentDao.queryIdListByCommandId(command.getId());
		for (CommandContent content : contentList) {
			if(existsIds.remove(content.getId())){
				updateList.add(content);
			}else{
				insertList.add(content);
			}
		}
		logger.debug(ReflectionToStringBuilder.toString(updateList));
		logger.debug(ReflectionToStringBuilder.toString(insertList));
		logger.debug(ReflectionToStringBuilder.toString(existsIds));
		if(updateList.size()>0)commandContentDao.updateBatch(updateList);
		if(insertList.size()>0)commandContentDao.insertBatch(insertList);
		if(existsIds.size()>0)commandContentDao.deleteBatch(existsIds);
		return true;
	}

}
