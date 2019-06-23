package com.tfl.service;

import com.tfl.pojo.Message;
import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public interface MessageService {
	/** 登录 */
	User login(String name,String pwd);
	
	/** 按照id查找用户 */
	User searchUserById(int id);

	/** 注册 */
	boolean register(User user);

	/** 按照id查找留言 */
	Message searchMessageById(int id);
	
	/** 发布留言 */
	boolean  publishMessage(Message msg);

	/** 修改留言 */
	boolean  editMessage(Message msg);

	/** 删除留言 */
	boolean  deleteMessageById(int id);

	/** 分页查询 */
	Paging<Message> search(int pageSize,int currPage);
}
