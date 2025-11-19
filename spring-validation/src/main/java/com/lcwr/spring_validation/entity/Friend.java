package com.lcwr.spring_validation.entity;

import jakarta.persistence.ElementCollection;
import lombok.Data;

@Data
public class Friend {
    private String name;
    private char gender;
}
