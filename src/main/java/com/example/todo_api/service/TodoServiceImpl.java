package com.example.todo_api.service;

import org.springframework.stereotype.Service;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.repo.Todorepository;
import java.util.*;

@Service
public class TodoServiceImpl implements TodoService {
    public Todorepository todorepo;

    public TodoServiceImpl(Todorepository todorepo) {
        this.todorepo = todorepo;
    }

    @Override
    public TodoModel createTodo(TodoModel task) {
        return todorepo.save(task);
    }
    @Override
    public List<TodoModel> getAllTodo()
    {
        return todorepo.findAll();
    }
    
    @Override 
    public TodoModel updateTodo(Long id,TodoModel task){
        TodoModel exTodo=todorepo.findById(id).orElse(null);
        if(exTodo == null)
            return null;

        exTodo.setTask(task.getTask());
        return todorepo.save(exTodo);
    }
    @Override
    public String deleteTodo(Long id){
        todorepo.deleteById(id);
        return "your task has been deleted";
    }
    
}