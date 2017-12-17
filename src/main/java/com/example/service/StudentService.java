package com.example.service;

import com.example.domain.Student;
import com.example.repository.StudentRepositoryImpl;
import org.springframework.stereotype.Service;

/**
 * Created by erdem on 17.12.2017.
 */
@Service
public class StudentService {

    private StudentRepositoryImpl studentRepositoryImpl;

    public StudentService(StudentRepositoryImpl studentRepositoryImpl) {
        this.studentRepositoryImpl = studentRepositoryImpl;
    }

    public void save(Student student){
        this.studentRepositoryImpl.saveStudent(student);
    }

}
