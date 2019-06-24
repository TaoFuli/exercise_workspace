package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tfl.pojo.Files;
import com.tfl.pojo.SharedFile;
import com.tfl.pojo.Users;
import com.tfl.utils.C3P0Utils;

public class SharedDaoImpl implements SharedDao{
	private final 	QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 根据登录名查询该用户的所有分享文件
	 * return 共享文件列表
	 */
	@Override
	public List<SharedFile> selectByloginName(String loginName) throws SQLException {
		String sql="select * from sharedFile where loginName=?;";
		return qr.query(sql, new BeanListHandler<SharedFile>(SharedFile.class),loginName);
		// TODO Auto-generated method stub
	}

	/**
	 * 	跟据路径查询该目录下的所有共享文件
	 * return 共享文件列表
	 */
	@Override
	public List<SharedFile> selectByfilePath(String filePath) throws SQLException {
		String sql="select * from sharedFile where filePath=?;";
		return qr.query(sql, new BeanListHandler<SharedFile>(SharedFile.class),filePath);
		// TODO Auto-generated method stub
	}
	/**
	 * 根据文件类型查询共享文件列表
	 * return 共享文件列表
	 */
	@Override
	public List<SharedFile> selectByfileType(String fileType) throws SQLException {
		String sql="select * from sharedFile where fileType=?;";
		return qr.query(sql, new BeanListHandler<SharedFile>(SharedFile.class),fileType);
		// TODO Auto-generated method stub
	}

	/**
	 * 查询所有共享文件
	 * return 共享文件列表
	 */
	@Override
	public List<SharedFile> selectAllsharedFile() throws SQLException {
		String sql="select * from sharedFile;";
		return  qr.query(sql, new ScalarHandler<>());
		// TODO Auto-generated method stub
	}

	/**
	 * 新建插入一个共享的文件到共享列表
	 * return (int)
	 * @throws SQLException 
	 */
	@Override
	public int insertByfilePath(Files file,SharedFile sharedFile) throws SQLException {
		String sql="INSERT INTO sharedFile(fileName,filePath,fileType,loginName,sharedTime,sCreateTime) VALUE(?,?,?,?,?,?);";
		//INSERT INTO sharedFile(fileName,filePath,fileType,loginName,sharedTime,sCreateTime)
		//VALUE('1.txt','d:/propram file/group9/','.txt','zhangsan','2018年11月09日','2018年10月30日');
		String[] params={file.getFilename(),file.getFileRoad(),file.getFileType()
				,selectById(file.getAuthor_id()).getLoginName()
				,sharedFile.getSharedTime()
				,sharedFile.getsCreateTime()};
		
		long update = qr.update(sql,new ScalarHandler<Long>(), params);
		return (int)update;
	}
	public Users selectById(int id){
		String sql="select * from Files where id=?;";
		try {
			return (Users)qr.query(sql, new BeanListHandler<Files>(Files.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除该文件的共享
	 * return (int)
	 */
	@Override
	public int deleteBySid(int sid) throws SQLException {
		String sql="delete from sharedFile where sid=?;";
		return qr.update(sql);
		// TODO Auto-generated method stub
	}
	
	/**
	 * 分页查询共享文件
	 */
	@Override
	public List<SharedFile> selectSharedFileLimit(int begin, int pageSize) throws SQLException {
		String sql="SELECT * FROM sharedFile LIMIT ?,?;";
		Object []params={begin,pageSize};
		return qr.query(sql, new BeanListHandler<SharedFile>(SharedFile.class),params);
	}
	
	/**
	 * 查询共享文件总数
	 * @throws SQLException 
	 */
	@Override
	public int selectAllCount() throws SQLException {
		String sql="select count(2) from sharedfile;";
		long l=qr.query(sql, new ScalarHandler<Long>());
		return (int)l;
	}
	
}
