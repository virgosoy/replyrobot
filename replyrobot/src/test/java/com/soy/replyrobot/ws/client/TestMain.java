package com.soy.replyrobot.ws.client;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * <p>WebService客户端测试程序</p>
 * @author zhengsiyou
 * @version 0.1
 */
public class TestMain {
	public static void main(String[] args) {
		ReplyRobotService replyRobotService = new ReplyRobotService();
		ReplyRobot replyRobotPort = replyRobotService.getReplyRobotPort();
//		String content = replyRobotPort.getContent("天气");
		Command command = replyRobotPort.getModel("天气");
		System.out.println(ReflectionToStringBuilder.toString(command));
	}
}
