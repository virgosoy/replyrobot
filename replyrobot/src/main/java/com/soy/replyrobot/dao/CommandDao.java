package com.soy.replyrobot.dao;

import java.util.List;

import com.soy.replyrobot.model.Command;

public interface CommandDao {
	
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
	 * <p>根据指令获取指令全部内容</p>
	 * @author zhengsiyou
	 * @param command
	 * @return 
	 */
	public Command queryFullCommandByName(String command);
	
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
	 * <p>修改指令</p>
	 * @author zhengsiyou
	 * @param command
	 * @return 
	 */
	public int update(Command command);
}
