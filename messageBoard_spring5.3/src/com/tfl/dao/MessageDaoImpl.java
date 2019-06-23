package com.tfl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.tfl.pojo.Message;
import com.tfl.pojo.User;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@Autowired
	private JdbcTemplate template ;
	
	
	
//留言信息的映射	
  private  RowMapper<Message>  messageRowMapper = new  RowMapper<Message>() {
	@Override
	public Message mapRow(ResultSet rs, int i) throws SQLException {
		Message  msg = new  Message();
		
		msg.setId(rs.getInt("id"));
		msg.setPublishTime(rs.getDate("publishTime"));
		msg.setAuthorId(rs.getInt("authorId"));
		msg.setContext(rs.getString("context"));
		
		return msg;
	}
  };
  
  //用户的映射信息
  private  RowMapper<User>  userRowMapper = new  RowMapper<User>() {
	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setLoginName(rs.getString("loginName"));
		user.setEmail(rs.getString("email"));
		user.setWriterName(rs.getString("writerName"));
		return user;
	}
	  
  };

	@Override
	public int insertMessage(Message msg) throws Exception {
		String sql = "INSERT INTO message(author_id,context) VALUES(?,?)";
		Object [] params = {msg.getAuthorId(),msg.getContext()};
		
		return template.update(sql, params);
	}

	@Override
	public int updateMessage(Message msg) throws Exception {
		String sql = "UPDATE message SET  context=? WHERE id = ?";
		Object [] params = {msg.getContext(),msg.getId()};
		
		return  template.update(sql, params);
	}

	@Override
	public int deleteMessage(int id) throws Exception {
		String sql = "DELETE FROM message WHERE id = ?";
		Object [] params = {id};
		return  template.update(sql, params);
	}

	@Override
	public int selectMessageCount() throws Exception {
		String sql = "SELECT COUNT(1) FROM message";
		
		SqlRowSet  rs = template.queryForRowSet(sql);
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	@Override
	public List<Message> selectAllMessages(int begin, int size) throws Exception {
		String sql = "SELECT id,publishTime,context,author_id authorId FROM message order by publishTime desc  limit ?,?";
		Object [] params = {begin,size};
		
		List<Message> list = template.query(sql,messageRowMapper,params);
		//循环 查找作者
		for(Message msg : list) {
			int authorid = msg.getAuthorId();
			//根据id找到作者
			User author = template.queryForObject("SELECT * FROM users WHERE id = ?",userRowMapper,authorid);
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
		
		Message msg = template.queryForObject(sql, messageRowMapper,params);
		
		//根据id找到作者
		int authorid = msg.getAuthorId();
		User author = template.queryForObject("SELECT * FROM users WHERE id = ?",userRowMapper,authorid);
		
		msg.setAuthor(author);
		
		return msg;
	}

}
