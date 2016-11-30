package com.soy.replyrobot.service;

import java.util.List;

import com.soy.replyrobot.model.Command;

public interface CommandService {
	
	/**
	 * <p>查询所有指令列表</p>
	 * @author zhengsiyou
	 * @return 
	 */
	public List<Command> queryCommandList(Command command);
	
	/**
	 * <p>查询指定指令的内容</p>
	 * @author zhengsiyou
	 * @param id
	 * @return 
	 */
	public Command queryFullCommandById(int id);
	
	/**
	 * <p>添加指令</p>
	 * @author zhengsiyou
	 * @param command
	 * @return 
	 */
	public boolean addCommand(Command command);
	
	/**
	 * <p>删除，可批量</p>
	 * @author zhengsiyou
	 * @param ids
	 * @return 
	 */
	public int delete(Integer[] ids);
	
	/**
	 * <p>修改整个指令，包括内容</p>
	 * @author zhengsiyou
	 * @return 
	 * @since 
	 */
	public boolean updateFullCommand(Command command);
	
}
