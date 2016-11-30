package com.soy.replyrobot.dao;

import java.util.List;

import com.soy.replyrobot.model.CommandContent;

public interface CommandContentDao {
	
	/**
	 * <p>批量修改内容</p>
	 * @author zhengsiyou
	 * @param contentList
	 * @return 
	 */
	public int updateBatch(List<CommandContent> contentList);
	
	
	/**
	 * <p>批量插入</p>
	 * @author zhengsiyou
	 * @param contentList
	 * @return 
	 */
	public int insertBatch(List<CommandContent> contentList);
	
	/**
	 * <p>判断id是否存在</p>
	 * @author zhengsiyou
	 * @param id
	 * @return 
	 */
	public boolean existsById(Integer id);
	
	
	/**
	 * <p>根据CommandId查询id列表</p>
	 * @author zhengsiyou
	 * @date 2016年11月29日-下午3:52:33
	 * @param commandId
	 * @return 
	 * @since 
	 */
	public List<Integer> queryIdListByCommandId(Integer commandId);
	
	/**
	 * <p>根据id列表批量删除</p>
	 * @author zhengsiyou
	 * @date 2016年11月29日-下午4:03:41
	 * @param ids
	 * @return 
	 * @since 
	 */
	public int deleteBatch(List<Integer> ids);
}
