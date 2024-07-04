package com.example.reactive.services;

import com.example.reactive.repositories.StudentRepo;
import com.example.reactive.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Mono<Student> save(Student student) {
        return studentRepo.save(student);
    }

    public Flux<Student> getAll() {
        return studentRepo.findAll();
    }

    public Mono<Student> getById(Integer id) {
        return studentRepo.findById(id);
    }

    public Flux<Student> getAllByFirstname(String firstname) {
        return studentRepo.findAllByFirstNameIgnoreCase(firstname);
    }

    public Flux<Student> getAllByEmail(String email) {
        return studentRepo.findAllByEmailIgnoreCase(email);
    }

    public Mono<Student> updateById(Integer id, Student newStudent){
        return studentRepo.findById(id).flatMap(student -> {
            if(newStudent.getFirstName() != null) student.setFirstName(newStudent.getFirstName());
            if(newStudent.getLastName() != null) student.setLastName(newStudent.getLastName());
            if(newStudent.getEmail() != null) student.setEmail(newStudent.getEmail());
            if(newStudent.getAge() != 0) student.setAge(newStudent.getAge());
            return studentRepo.save(student);
        });
    }

    public Mono<Void> deleteById(Integer id) {
        return studentRepo.deleteById(id);
    }
}
