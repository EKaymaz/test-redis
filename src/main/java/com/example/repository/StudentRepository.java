package com.example.repository;

import com.example.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by erdem on 17.12.2017.
 */
public interface StudentRepository extends CrudRepository<Student, String> {

}
