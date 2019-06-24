package com.tfl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tfl.pojo.User;

public class UserDaoImpl implements UserDao {
	User user=null;
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public User selectByLoginNameAndPassword(String loginName, String password) {
		String sql="SELECT * FROM  users WHERE  loginName=? AND PASSWORD = ?;";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				user = new User();
				//封装
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setLoginName(rs.getString("loginName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return user;
	}

	@Override
	public List<User> selectByUserName(String username) {
		List<User> userList=new ArrayList<>();
		String sql="SELECT * FROM users WHERE  username LIKE ?;";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+username+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				//封装
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setLoginName(rs.getString("loginName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
				
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public int insertByUser(User user) {
		String sql="INSERT INTO users(username,loginName,PASSWORD,sex,email) VALUE(?,?,?,?,?);";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getLoginName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
//			ps.setString(5,user.getBirthday());
			ps.setString(5, user.getEmail());
			user.toString();
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 数据库连接
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("获取数据库驱动失败！！！");
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root","root");
	}

	@Override
	public int removeByLoginName(User user) {
		String sql="DELETE FROM users WHERE loginName=?;";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getLoginName());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
