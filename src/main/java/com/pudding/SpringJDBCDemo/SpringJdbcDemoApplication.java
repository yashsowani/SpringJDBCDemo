package com.pudding.SpringJDBCDemo;

import com.pudding.SpringJDBCDemo.model.Person;
import com.pudding.SpringJDBCDemo.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Person person = context.getBean(Person.class);
		person.setId(103);
		person.setName("Sowani");
		person.setTech("Hibernate");


		PersonRepository repo = context.getBean(PersonRepository.class);
		repo.save(person);


		System.out.println(repo.findAll());
	}

}
