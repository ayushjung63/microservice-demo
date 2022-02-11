package com.ayush.studentservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String faculty;
    private String address;

    public Student(String name, String faculty, String address) {
        this.name = name;
        this.faculty = faculty;
        this.address = address;
    }
}
