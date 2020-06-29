package com.test.mongotest.service;

import com.test.mongotest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceImpl {

	@Resource
	private StudentRepository studentRepository;

//	List<Student> findall(String name) {
//		return studentRepository.findByNameIn(name);
//	}


}
