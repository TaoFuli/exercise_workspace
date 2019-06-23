package com.tfl.mapper;

import java.util.List;

import com.tfl.pojo.Student;

public interface StudentMapper {
	public Student selectById(int id);
	public List<Student> selectAll();
	public int insertUser(Student st);
}
