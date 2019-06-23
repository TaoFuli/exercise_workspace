package com.tfl.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tfl.mapper.StudentMapper;
import com.tfl.pojo.Student;

public class TestMapper {
	private SqlSessionFactory factory;
	
	@Before
	public void before() throws IOException {
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		factory=builder.build(Resources.getResourceAsStream("sqlMapperConfig.xml"), "development1");
	}
	@Test
	public void selectById() {
		SqlSession session=factory.openSession();
		Student st=(Student)session.selectOne("com.tfl.mapper.StudentMapper.selectById",100);
		System.out.println(st);
	}
	@Test
	public void selectById2() {
		SqlSession session=factory.openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		Student st=mapper.selectById(1000);
		System.out.println(st);
	}
	@Test
	public void selectAll() {
		SqlSession session=factory.openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		List<Student> st=mapper.selectAll();
		for(Student student:st) {
			System.out.println(student);
		}
	}
	
}
