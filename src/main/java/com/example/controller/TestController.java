package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<Student> addDataToRedis() {
        Student s = new Student();
        s.setName("testStudent");
        s.setGender(Student.Gender.MALE);
        s.setGrade(100);
        s.setId("1");
        this.studentService.save(s);
        return new ResponseEntity<Student>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<String> showDataFromRedis() {
        return new ResponseEntity<String>("erdem", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> showDataFromRedis(@PathVariable(value = "id") String id) {
        Student st = studentService.getOneById(id);
        return new ResponseEntity<Student>(st, HttpStatus.OK);
    }
}
