package com.ayush.shared.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int paidAmount;
    private int studentId;
}
