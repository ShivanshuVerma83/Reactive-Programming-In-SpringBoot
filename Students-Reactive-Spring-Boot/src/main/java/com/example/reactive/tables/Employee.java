package com.example.reactive.tables;

import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("employees")
public class Employee {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;

}
