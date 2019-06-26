package com.igeek.school.dao;

import java.util.List;

import com.igeek.school.domain.Student;

public interface IStudentDAO 
{
	/**  添加学生的方法
	 * @param name	学生的名字
	 * @return	影响的行数
	 */
	public int addStudent(String name);

	// 查询所学生的方法
	public List<Student> findAll();
	

}
