package com.example.FinalProjectJava.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonCalculator {
    private String name;
    private int age;
}

