package com.test.mongotest.test;

import com.test.mongotest.repository.StudentRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Junit {

	@Resource
	private StudentRepository studentRepository;

//	@Test
//	public void add() {
//		studentRepository.insert(new Student(2, "wangnian"));
//	}

}
