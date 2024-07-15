package com.jwtauthentication.demo.controller;

import com.jwtauthentication.demo.entity.Todo;
import com.jwtauthentication.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(Authentication authentication) {
        String userId = authentication.getName(); // Get userId from authentication
        return todoService.getTodos(userId);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo, Authentication authentication) {
        String userId = authentication.getName(); // Get userId from authentication
        todo.setUserId(userId);
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todoDetails) {
        return todoService.updateTodo(id, todoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }
}
