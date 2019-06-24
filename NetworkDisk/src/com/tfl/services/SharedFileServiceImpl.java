package com.tfl.services;

import java.sql.SQLException;
import java.util.List;

import com.tfl.dao.SharedDao;
import com.tfl.dao.SharedDaoImpl;
import com.tfl.pojo.Files;
import com.tfl.pojo.Paging;
import com.tfl.pojo.SharedFile;

public class SharedFileServiceImpl implements SharedFileService{
	private final SharedDao sdao=new SharedDaoImpl();

	public Paging<SharedFile> search(int pageSize, int currPage) {
		Paging<SharedFile> paging=new Paging<>(pageSize,currPage);
		try {
			int rowsCount=sdao.selectAllCount();
			int pageCount=(int)Math.ceil(rowsCount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<SharedFile> data=sdao.selectSharedFileLimit(begin, pageSize);
			//封装到paging
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paging;
	}

	@Override
	public int insertByfilePath(Files file, SharedFile sharedFile) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBySid(int sid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SharedFile> selectByloginName(String loginName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SharedFile> selectByfilePath(String filePath) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SharedFile> selectByfileType(String fileType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SharedFile> selectAllsharedFile() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SharedFile> selectSharedFileLimit(int begin, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
