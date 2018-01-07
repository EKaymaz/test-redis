package com.example.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by erdem on 07.01.2018.
 */
public interface RedisRepository<T extends Serializable> {

    List<T> findAll();

    void add(T movie);

    void delete(String id);

    T findOne(String id);

}
