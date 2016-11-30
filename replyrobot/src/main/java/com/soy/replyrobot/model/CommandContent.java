package com.soy.replyrobot.model;

/**
 * <p>CommandContent表</p>
 * @author zhengsiyou
 */
public class CommandContent {
	private Integer id;
	private Integer commandId;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCommandId() {
		return commandId;
	}
	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
