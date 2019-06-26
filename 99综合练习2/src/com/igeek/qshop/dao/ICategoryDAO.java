package com.igeek.qshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.qshop.pojo.Admin;
import com.igeek.qshop.pojo.Category;

public interface ICategoryDAO 
{
	/**
	 * 添加商品分类
	 * @param name
	 * @return
	 */
	public boolean add(String name)throws SQLException;
	
	/**
	 * 删除商品分类
	 * @param id
	 * @return
	 */
	public boolean removeByID(int id)throws SQLException;
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean removeByName(String name)throws SQLException;
	
	/**
	 * 修改商品分类名
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean modify(int id,String name)throws SQLException;
	
	/**
	 * 根据id查询商品分类
	 * @param id
	 * @return
	 */
	public Category findByID(int id)throws SQLException;
	/**
	 * 根据分类名查询商品分类
	 * @param name
	 * @return
	 */
	public Category findByName(String name)throws SQLException;

	/**
	 * 查询所有商品分类
	 * @return
	 */
	public List<Category> findAll()throws SQLException;
}


// 接口中的定义的方法 声明了抛异常
// 实现类的方法 可以不抛,如果要抛,需要是 和接口中方法定义的异常类型一致或其子类
