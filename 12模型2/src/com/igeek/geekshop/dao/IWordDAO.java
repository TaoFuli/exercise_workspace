package com.igeek.geekshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.geekshop.domain.Word;

public interface IWordDAO 
{
	// 增
	public boolean add(String word,int user_id) throws SQLException;
	
	// 删
	public boolean removeByID(int id) throws SQLException;
	public boolean removeByWord(String word) throws SQLException;
	
	// 修改
	public boolean modify(Word word) throws SQLException;
	
	// 查询
	public Word findById(int id) throws SQLException;
	public Word findByWord(String word) throws SQLException;
	public List<Word> findAll(int user_id) throws SQLException;

}
