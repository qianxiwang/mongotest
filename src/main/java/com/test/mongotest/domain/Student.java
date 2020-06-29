package com.test.mongotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


//@JsonIgnoreProperties(ignoreUnknown = true)
@Document("student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

	@Id
	private Integer id;
	private String name;
	private String sex;

}
