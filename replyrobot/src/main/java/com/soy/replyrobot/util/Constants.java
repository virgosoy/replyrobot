package com.soy.replyrobot.util;

public final class Constants {
	private Constants() {
	}
	
	/**
	 * 帮助指令
	 * @since
	 */
	public static final String HELP_COMMAND = "帮助";
	
	/**
	 * 未匹配到指令时发送的内容
	 * @since
	 */
	public static final String NO_MATCHING_CONTENT = "客官，你没按套路出牌……我听不懂你在说什么哎！输入【"+HELP_COMMAND+"】可查看帮助列表";
	
	/**
	 * 空指令
	 * @since
	 */
	public static final String EMPTY_COMMAND_CONTENT = "客官，您输入的指令为空，请重写输入。";
	
}
