package com.example.service;

import com.example.domain.Student;
import com.example.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class StudentService implements RedisRepository<Student> {

    private static final String KEY = "Student";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public StudentService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Student student) {
        hashOperations.put(KEY, student.getId(), student);
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Student findOne(final String id) {
        return (Student) hashOperations.get(KEY, id);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Map<Object, Object> map = hashOperations.entries(KEY);

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            students.add((Student) entry.getValue());
        }

        return students;
    }
}
