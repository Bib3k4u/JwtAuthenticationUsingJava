package com.jwtauthentication.demo.service;

import com.jwtauthentication.demo.entity.Todo;
import com.jwtauthentication.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos(String userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo createTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo todoDetails) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
}
