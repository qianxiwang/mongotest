package com.test.mongotest.repository;

import com.test.mongotest.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	@Query("{'name':?0}")
	List<Student> findByNameIn(String name);

}
