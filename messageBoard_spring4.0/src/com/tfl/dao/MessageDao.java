package com.tfl.dao;

import java.util.List;

import com.tfl.pojo.Message;

/**
 * 留言消息数据库访问对象接口
 */
public interface MessageDao {

	/** 按照Id查询 */
	Message selectById(int id) throws Exception;

	/** a> 插入新的留言 */
	int insertMessage(Message msg) throws Exception;

	/** b> 修改留言，编号不能修改 */
	int updateMessage(Message msg) throws Exception;

	/** c> 删除留言，按照编号删除 */
	int deleteMessage(int id) throws Exception;

	/** d> 查询出留言的数量 */
	int selectMessageCount() throws Exception;

	/** e> 查询出留言的记录集合 */
	List<Message> selectAllMessages(int begin, int size) throws Exception;
}
