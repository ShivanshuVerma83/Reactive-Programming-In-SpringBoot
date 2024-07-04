package com.example.reactive;

import com.example.reactive.services.StudentService;
import com.example.reactive.tables.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentService studentService) {
//		return args -> {
//			studentService.save(Student.builder().firstName("Kareem").lastName("Ezzat").email("kareem@gmail.com").age(23).build()).subscribe();
//			studentService.save(Student.builder().firstName("Foo").lastName("Bar").email("foo@gmail.com").age(33).build()).subscribe();
//			studentService.save(Student.builder().firstName("John").lastName("Doe").email("john@gmail.com").age(22).build()).subscribe();
//			studentService.save(Student.builder().firstName("Kevin").lastName("Hart").email("kevin@gmail.com").age(45).build()).subscribe();
//		};
//	}

}
