package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class Student implements Serializable {

    public enum Gender {
        @JsonProperty("male")
        MALE,

        @JsonProperty("female")
        FEMALE;
    }

    private String id;

    private String name;
    private Gender gender;
    private int grade;

    public Student(String id, String name, Gender gender, Integer grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public Student() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    @JsonProperty(value = "name")
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    @JsonProperty(value = "gender")
    public Student setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    @JsonProperty(value = "grade")
    public Student setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + '\'' + ", name =" + name + "}" + '\''
                + ", gender =" + gender + "}" + '\'' + ", grade =" + grade + "}";
    }
}