package com.jwtauthentication.demo.repository;

import com.jwtauthentication.demo.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByUserId(String userId);
}
