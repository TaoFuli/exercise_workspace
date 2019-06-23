package com.tfl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tfl.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate template ;
	
	//spring注入
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
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
	public User selectByLoginNameAndPassword(String loginName, String password) throws Exception {
		String sql = "SELECT * FROM users WHERE loginName = ? AND `password`=PASSWORD(?)";
		Object [] params = {loginName,password};
		
		return template.queryForObject(sql, userRowMapper,params);
	}

	@Override
	public int insertUser(User user) throws Exception {
		String sql = "INSERT INTO users(username,loginname,`password`,email,writerName)  " + 
				"VALUES(?,?,PASSWORD(?),?,?)";
		
		Object [] params = {user.getUsername(),user.getLoginName(),
				user.getPassword(),user.getEmail(),user.getWriterName()};
		
		return template.update(sql, params);
	}

	/**
	 * 按照Id查找 用户
	 */
	@Override
	public User selectById(int id) throws Exception {
		String sql = "SELECT * FROM users WHERE id = ?";
		Object [] params = {id};
		
		return template.queryForObject(sql, userRowMapper,params);
	}

}
