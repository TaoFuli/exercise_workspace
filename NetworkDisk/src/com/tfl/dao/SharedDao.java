package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import com.tfl.pojo.Files;
import com.tfl.pojo.SharedFile;

public interface SharedDao {
	/*添加共享文件*/ 
	public int insertByfilePath(Files file,SharedFile sharedFile) throws SQLException;
	/*取消共享，删除共享表*/
	public int deleteBySid(int sid) throws SQLException;
	//通过用户登录名查询该用户的共享文件
	public List<SharedFile> selectByloginName(String loginName) throws SQLException;
	//通过共享路径查询共享的文件
	public List<SharedFile> selectByfilePath(String filePath) throws SQLException;
	//通过文件类型查询共享文件
	public List<SharedFile> selectByfileType(String fileType) throws SQLException;
	//查询所有的已共享文件
	public List<SharedFile> selectAllsharedFile() throws SQLException;
	//分页查询共享文件
	public List<SharedFile> selectSharedFileLimit(int begin, int pageSize) throws SQLException;
	//查询分页查询共享文件总数
	public int selectAllCount() throws SQLException;
}
