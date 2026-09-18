package com.example.todo_api.service;

import com.example.todo_api.model.TodoModel;
import java.util.*;

public interface TodoService {
    public TodoModel createTodo(TodoModel task);
      List<TodoModel> getAllTodo();
    public TodoModel updateTodo (Long id,TodoModel task);

    public String deleteTodo(Long id);

}