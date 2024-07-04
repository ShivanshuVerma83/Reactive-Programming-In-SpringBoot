package com.example.reactive.services;


import com.example.reactive.repositories.EmployeeRepo;
import com.example.reactive.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import reactor.core.publisher.Flux;


@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Mono<Employee> save(Employee student) {
        return employeeRepo.save(student);
    }

    public Flux<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Flux<Employee> getByfirstName(String firstName) {
        return employeeRepo.findallbyfirstname(firstName);
    }

    public Mono<Employee> getById(Integer id) {
        return employeeRepo.findById(id);
    }

    public Mono<Employee> updatebyId(Integer id,Employee employeee){
        return employeeRepo.findById(id).flatMap(employee -> {
            if(employeee.getFirstName()!=null) employeee.setFirstName(employeee.getFirstName());
            if(employeee.getLastName()!=null) employeee.setLastName(employeee.getLastName());
            if(employeee.getId()!=0) employeee.setId(employeee.getId());
            return employeeRepo.save(employee);
        });
    }

    public Mono<Void> deletebyID(Integer id){
        return employeeRepo.deleteById(id);
    }

}


