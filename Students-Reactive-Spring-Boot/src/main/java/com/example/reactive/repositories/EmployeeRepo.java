package com.example.reactive.repositories;

import com.example.reactive.tables.Employee;
import com.example.reactive.tables.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Integer> {

    Flux<Employee> findbyid(Integer id);
    Flux<Employee> findallbyfirstname(String firstName);
    Flux<Employee> findAlllastname(String lastName);



}
