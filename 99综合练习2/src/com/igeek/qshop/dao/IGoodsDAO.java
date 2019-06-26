package com.igeek.qshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.qshop.pojo.Goods;

public interface IGoodsDAO 
{
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public boolean add(Goods goods)throws SQLException;
	
	/**
	 * 根据商品编号删除商品
	 * @param id
	 * @return
	 */
	public boolean removeByID(int id)throws SQLException;
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public boolean modify(Goods goods)throws SQLException;
	
	/**
	 * 根据商品编号查询商品对象
	 * @param id
	 * @return
	 */
	public Goods findByID(int id)throws SQLException;
	/**
	 * 查询所有商品列表
	 * @return
	 */
	public List<Goods> findAll()throws SQLException;

}
