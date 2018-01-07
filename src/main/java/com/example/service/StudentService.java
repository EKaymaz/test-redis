package com.example.service;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Created by erdem on 17.12.2017.
 */
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        this.studentRepository.save(student);
    }

    public Student getOneById(String id) {
        return this.studentRepository.findOne(id);
    }

}
