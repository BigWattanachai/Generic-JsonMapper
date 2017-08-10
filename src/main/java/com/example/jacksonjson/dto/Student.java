package com.example.jacksonjson.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Student {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("gpa")
    public Double gpa;
}
