package com.test.mongotest.controller;

import com.test.mongotest.domain.Student;
import com.test.mongotest.repository.StudentRepository;
import com.test.mongotest.utils.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(description = "学生接口")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@PostMapping("/students")
//	@GetMapping("/students")
	@ApiOperation(value = "添加学生", notes = "添加一个学生")
	@Cacheable(cacheNames = "student", key = "#student.id")
	public AjaxResponse addStudent(@RequestBody Student student) {
//	public AjaxResponse addStudent() {
//		Student student = new Student();
//		student.setId(20);
//		student.setName("aaaa");
//		student.setSex("女");
		studentRepository.save(student);
		return AjaxResponse.success();
	}

	@GetMapping("/students/{id}")
	@ApiOperation(value = "获取学生", notes = "根据id查询一个学生")
	@Cacheable(value = "student", key = "#id")
	public AjaxResponse query(@PathVariable("id") Integer id) {
		System.out.println("只打印一次，测试缓存。。。。。。。。。。。。。。。。。。。。");
		Optional<Student> _Student = studentRepository.findById(id);
		return AjaxResponse.success(Optional.ofNullable(_Student).get().orElse(null));
	}

	@PutMapping("/students")
	@ApiOperation(value = "更新学生", notes = "更新一个学生")
	@CachePut(value = "student", key = "#student.id")//该注解用于更新缓存中的注解
	public AjaxResponse update(@RequestBody Student student) {
		studentRepository.save(student);
		return AjaxResponse.success();
	}

	@DeleteMapping("/students/{id}")
	@ApiOperation(value = "删除学生", notes = "根据id删除一个学生")
	@CacheEvict(value = "student", key = "#id")//该注解用于删除缓存
	public void delete(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}

	@GetMapping("/test")
	@Cacheable(value = "student", key = "#name")
	public List<Student> test(@RequestParam("name") String name) {
		return studentRepository.findByNameIn(name);
	}

}
