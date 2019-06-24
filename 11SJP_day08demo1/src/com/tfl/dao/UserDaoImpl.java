package com.tfl.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.User;
import com.tfl.utils.C3P0Utils;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 完成登录查询
	 * @throws SQLException 
	 */
	@Override
	public User selectByloginNameAndPassword(String loginName, String password) throws SQLException {
		String sql="select * from luser where uloginName=? and upassword=?";
		Object params[]= {loginName,password};
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}
	/**
	 * 注册用户信息
	 * @throws SQLException 
	 */
	@Override
	public int insertByUser(User user) throws SQLException {
		String sql="INSERT INTO luser(username,uloginName,upassword,usex,ubirthday,uemail) VALUE(?,?,?,?,?,?);";
		Object params[]= {user.getUsername(),user.getUloginName(),user.getUpassword()
				,user.getUsex(),user.getUbirthday(),user.getUemail()};
		return qr.update(sql, params);
		// TODO Auto-generated method stub
	}
	/**
	 * 登录名模糊查询所有用户信息
	 * @throws SQLException 
	 */
	@Override
	public List<User> selectByloginName(String queryString) throws SQLException {
		String sql="select * from luser where uloginName like ?";
		Object params[]= {"%"+queryString+"%"};
		return qr.query(sql,new BeanListHandler<>(User.class),params);
		// TODO Auto-generated method stub
	}

	/**
	 * 修改用户信息
	 * @throws SQLException 
	 */
	@Override
	public int editUser(User user) throws SQLException {
		String sql="update luser set=? where uid=?;";
		String set=user.getUsername()
			+",set="+user.getUloginName()
			+",set="+user.getUpassword()
			+",set="+user.getUsex()
			+",set="+user.getUbirthday()
			+",set="+user.getUemail();
		Object params[]= {set,user.getUid()};
		return qr.update(sql, params);
		// TODO Auto-generated method stub
	}

	/**
	 * 删除用户信息
	 * @throws SQLException 
	 */
	@Override
	public int removeUser(User user) throws SQLException {
		String sql="delete from luser where uid=?";
		Object params[]= {user.getUid()};
		return qr.update(sql, params);
		// TODO Auto-generated method stub
	}

	/**
	 * 添加留言信息
	 * @throws SQLException 
	 */
	@Override
	public int insertByLeaveWord(LeaveWord leaveword) throws SQLException {
		String sql="insert into leaveWord(fk_uloginName,wleaveWord,wtime,date) value(?,?,?,?);";
		Object[] params= {leaveword.getFk_uloginName(),leaveword.getWleaveWord(),new Date()
					,new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss").format(new Date().getTime()).toString() };
		return qr.update(sql, params);
		// TODO Auto-generated method stub
	}

	/**
	 * 查询该用户的所有留言
	 * @throws SQLException 
	 */
	@Override
	public List<LeaveWord> selectByloginName(User user) throws SQLException {
		String sql="select * from leaveWord where fk_uloginName=?;";
		Object[] params= {user.getUloginName()};
		return qr.query(sql, new BeanListHandler<>(LeaveWord.class), params);
		// TODO Auto-generated method stub
	}

	/**
	 * 查询所有留言
	 * @throws SQLException 
	 */
	@Override
	public List<LeaveWord> selectByleaveWord(int begin,int size) throws SQLException {
		String sql="select * from leaveWord order by date desc limit ?,?;";
		Object[] params= {begin,size};
		return qr.query(sql, new BeanListHandler<>(LeaveWord.class),params);
		// TODO Auto-generated method stub
	}

	/**
	 * 修改留言内容
	 * @throws SQLException 
	 */
	@Override
	public int editLeaveWord(LeaveWord leaveword) throws SQLException {
		String sql="update leaveWord set wleaveWord=?,date=? where wid=?;";
		Object[] params= {leaveword.getWleaveWord()
				,new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss").format(new Date().getTime()).toString()
				,leaveword.getWid()};
		return qr.update(sql, params);
		// TODO Auto-generated method stub
	}

	/**
	 * 删除该条留言
	 * @throws SQLException 
	 */
	@Override
	public int removeLeaveWord(LeaveWord leaveword) throws SQLException {
		String sql="delete from leaveWord where wid=?;";
		Object[] params= {leaveword.getWid()};
		return qr.update(sql, params);
		// TODO Auto-generated method stub      
	}
	@Override
	public int selectLeaveWordCount() throws SQLException {
		String sql="select count(0) from leaveWord";
		// TODO Auto-generated method stub
		long count=qr.query(sql, new ScalarHandler<>());
		return (int)count;
	}
	
	@Override
	public LeaveWord selectByWid(int wid) throws SQLException {
		String sql="select * from leaveWord where wid=?";
		return qr.query(sql, new BeanHandler<>(LeaveWord.class),wid);
		// TODO Auto-generated method stub
	}

}
