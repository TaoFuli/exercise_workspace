package com.tfl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tfl.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate template;
	
	//映射RowMapper
	private RowMapper<User> rowMapper=new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int i) throws SQLException {
			//实例化用户对像
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setSex(rs.getString("sex"));
			u.setBirthday(rs.getDate("birthday"));
			u.setEmail(rs.getString("email"));
			return u;
		}};
	
	@Override
	public int insert(User user) {
		String sql="INSERT INTO user(name,sex,birthday,email) VALUES(?,?,?,?);";
		Object args[]= {user.getName(),user.getSex(),user.getBirthday(),user.getEmail()};
		return template.update(sql, args);
	}

	@Override
	public int delete(int id) {
		String sql="DELETE FROM user WHERE id=?;";
		return template.update(sql, id);
	}

	@Override
	public int update(User user) {
		String sql="UPDATE user SET name=?,sex=?,birthday=?,email=? WHERE id=?;";
		Object[] args= {user.getName(),user.getSex(),user.getBirthday(),user.getEmail(),user.getId()};
		return template.update(sql, args);
	}

	@Override
	public User select(int id) {
		String sql="SELECT * FROM user WHERE id=?;";
		List<User> list=template.query(sql, rowMapper,id);
		return list.get(0);
	}

	@Override
	public List<User> select(String name) {
		String sql="SELECT * FROM user WHERE name LIKE ?;";
		return template.query(sql, rowMapper,"%"+name+"%");
	}

}
