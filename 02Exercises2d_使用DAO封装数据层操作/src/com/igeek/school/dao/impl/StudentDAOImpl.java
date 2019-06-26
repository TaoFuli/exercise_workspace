package com.igeek.school.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.school.dao.IStudentDAO;
import com.igeek.school.domain.Student;
import com.igeek.utils.JDBCUtils;

public class StudentDAOImpl implements IStudentDAO
{

	@Override
	public int addStudent(String name) 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into students values (null,?)";
		Object[] params = {name};
		int result = 0;
		try {
			result = runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> findAll() {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from students";
		List<Student> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
