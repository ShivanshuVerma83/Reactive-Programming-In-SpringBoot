package com.example.reactive.repositories;

import com.example.reactive.tables.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepo extends ReactiveCrudRepository<Student, Integer> {

    Flux<Student> findAllByFirstNameIgnoreCase(String firstname);
    Flux<Student> findAllByEmailIgnoreCase(String email);
}
