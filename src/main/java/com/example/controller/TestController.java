package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Test Controller
 */
@RestController
@RequestMapping("/action")
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        this.studentService.add(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<List<Student>>(this.studentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getOne(@PathVariable(value = "id") String id) {
        Student st = studentService.findOne(id);
        return new ResponseEntity<Student>(st, HttpStatus.OK);
    }
}
