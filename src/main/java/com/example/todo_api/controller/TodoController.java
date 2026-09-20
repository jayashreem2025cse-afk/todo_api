package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;


import com.example.todo_api.model.TodoModel;
import com.example.todo_api.service.TodoService;
import java.util.*;


@RestController
@RequestMapping("/todos")
public class TodoController {
    public TodoService todoser;

    public TodoController(TodoService todoser) {
        this.todoser = todoser;
    }

    @PostMapping("/createTodo")
    
    public TodoModel createTodo(@RequestBody TodoModel task) {
        return todoser.createTodo(task);
    }

    @GetMapping("/getTodo")
    public List<TodoModel> getAllTodo(){
        return todoser.getAllTodo();
    }
    @PutMapping("/updateTodo/{id}")
    public TodoModel updateTodo(@PathVariable Long id,@RequestBody TodoModel Task){
        return todoser.updateTodo(id,Task);
    }
    @DeleteMapping("/deleteTodo/{id}")
    public String  deleteTodo(@PathVariable Long id){
        todoser.deleteTodo(id);
        return "your task has been deleted";
    }

}