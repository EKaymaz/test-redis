package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private Gender gender;
    private int grade;

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

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Student setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public Student setGrade(int grade) {
        this.grade = grade;
        return this;
    }
}