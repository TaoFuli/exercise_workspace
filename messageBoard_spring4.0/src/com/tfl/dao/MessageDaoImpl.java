package com.tfl.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tfl.pojo.Message;
import com.tfl.pojo.User;

@Repository("msgDao")
public class MessageDaoImpl implements MessageDao {
	//依赖DButils
	@Autowired
	@Qualifier("queryRunner")
	private QueryRunner qr ;
	

	@Override
	public int insertMessage(Message msg) throws Exception {
		String sql = "INSERT INTO message(author_id,context) VALUES(?,?)";
		Object [] params = {msg.getAuthorId(),msg.getContext()};
		
		return qr.update(sql, params);
	}

	@Override
	public int updateMessage(Message msg) throws Exception {
		String sql = "UPDATE message SET  context=? WHERE id = ?";
		Object [] params = {msg.getContext(),msg.getId()};
		
		return  qr.update(sql, params);
	}

	@Override
	public int deleteMessage(int id) throws Exception {
		String sql = "DELETE FROM message WHERE id = ?";
		Object [] params = {id};
		return  qr.update(sql, params);
	}

	@Override
	public int selectMessageCount() throws Exception {
		long count = qr.query("SELECT COUNT(1) FROM message", new ScalarHandler<>());
		return (int)count;
	}

	@Override
	public List<Message> selectAllMessages(int begin, int size) throws Exception {
		String sql = "SELECT id,publishTime,context,author_id authorId FROM message order by publishTime desc  limit ?,?";
		Object [] params = {begin,size};
		//查询出Message集合
		List<Message> list = qr.query(sql, new BeanListHandler<Message>(Message.class),params);
		
		//循环 查找作者
		for(Message msg:list) {
			int authorid = msg.getAuthorId();
			//根据id找到作者
			User author = qr.query("SELECT * FROM users WHERE id = ?", 
					new BeanHandler<User>(User.class),authorid);
			msg.setAuthor(author);
		}
		
		return list;
	}

	/**
	 *   通过ID查找消息
	 */
	@Override
	public Message selectById(int id) throws Exception {
		String sql = "SELECT id,publishTime,context,author_id authorId FROM message where id = ?";
		Object [] params = {id};
		
		Message msg = qr.query(sql, new BeanHandler<Message>(Message.class),params);
		
		int authorid = msg.getAuthorId();
		//根据id找到作者
		User author = qr.query("SELECT * FROM users WHERE id = ?", 
				new BeanHandler<User>(User.class),authorid);
		msg.setAuthor(author);
		
		return msg;
	}

}
