package com.ayush.accountservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private int paidAmount;
    private int studentId;

    public Fee(int paidAmount,String title, int studentId) {
        this.paidAmount = paidAmount;
        this.studentId = studentId;
        this.title=title;
    }
}
