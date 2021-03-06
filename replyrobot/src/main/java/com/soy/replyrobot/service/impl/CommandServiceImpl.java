package com.soy.replyrobot.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soy.replyrobot.dao.CommandContentDao;
import com.soy.replyrobot.dao.CommandDao;
import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.model.CommandContent;
import com.soy.replyrobot.service.CommandService;
import com.soy.replyrobot.service.logic.CommandMethod;
import com.soy.replyrobot.util.Constants;
import com.soy.replyrobot.util.StringUtils;

@Service
public class CommandServiceImpl implements CommandService {
	private Logger logger = Logger.getLogger(CommandServiceImpl.class);

	@Autowired
	private CommandDao commandDao;
	@Autowired
	private CommandContentDao commandContentDao;
	@Autowired
	private CommandMethod commandMethod;
	
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

	@Override
	public String autoReply(String name) {
		if(StringUtils.isEmpty(name)){
			return Constants.EMPTY_COMMAND_CONTENT;
		}
		if(Constants.HELP_COMMAND.equals(name)){
			//如果是帮助指令
			List<Command> commandList = commandDao.queryCommandList(null);
			StringBuilder sb = new StringBuilder("帮助列表：");
			for(Command command : commandList){
				sb.append("<br>");
				sb.append("输入[");
				sb.append(command.getCommand());
				sb.append("]查看");
				sb.append(command.getDescription());
			}
			for(Entry<String, String> entry : CommandMethod.methodDescriptionMap.entrySet()){
				sb.append("<br>");
				sb.append("输入[");
				sb.append(entry.getKey());
				sb.append("]查看");
				sb.append(entry.getValue());
			}
			//输出帮助内容
			return sb.toString();
		}else if(CommandMethod.methodMap.containsKey(name)){ //如果指令绑定了方法
			try {
				return (String) CommandMethod.methodMap.get(name).invoke(commandMethod);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}else{
			//一般指令
			Command command = commandDao.queryFullCommandByName(name);
			if(command!=null){ //返回结果不为null表示有对应的指令
				List<CommandContent> contentList = command.getContentList();
				if(contentList!=null && contentList.size()>0){ //如果指令有回复结果
					CommandContent content = contentList.get(new Random().nextInt(contentList.size()));
					return content.getContent();
				}else{
					return Constants.NO_REPLY_CONTENT;
				}
			}
		}
		return Constants.NO_MATCHING_CONTENT;
	}

	@Override
	public Command queryFullCommandByName(String command) {
		return commandDao.queryFullCommandByName(command);
	}

}
