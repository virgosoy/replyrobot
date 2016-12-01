package com.soy.replyrobot.ws;

import javax.jws.WebService;

import com.soy.replyrobot.model.Command;

@WebService
public interface ReplyRobot {
	/**
	 * <p>根据指令获取自动回复内容</p>
	 * @author zhengsiyou
	 * @param command
	 * @return 
	 */
	public String getContent(String command);

	/**
	 * <p>根据指令获取指令模型</p>
	 * @author zhengsiyou
	 * @param command
	 * @return 
	 */
	public Command getModel(String command);
	
}
