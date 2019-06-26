package com.igeek.school.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.school.dao.impl.StudentDAOImpl;
import com.igeek.school.domain.Student;

import junit.framework.TestCase;

class IStudentDAOTest {

	IStudentDAO dao = new StudentDAOImpl();
	
	@Test
	void testAddStudent() {
		
		int result = dao.addStudent("张飞");
		TestCase.assertTrue(result>0);
	}

	@Test
	void testFindAll() {
	
		List<Student> list = dao.findAll();
		TestCase.assertNotNull(list);
		for(Student stu:list)
		{
			System.out.println(stu);
		}
	}

}
