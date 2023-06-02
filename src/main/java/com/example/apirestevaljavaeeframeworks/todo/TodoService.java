package com.example.apirestevaljavaeeframeworks.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository  repositoryTodo;
    public List<Todo> getAllTodos() {
        List<Todo> todos = (List<Todo>) repositoryTodo.findAll();
        return todos;
    }
    public Optional<Todo> getTodo(int id) {
        Optional<Todo> todoOptional=repositoryTodo.findById(id);
        return todoOptional;
    }
    public Todo saveTodo(Todo todo) {
        return repositoryTodo.save(todo);
    }
    public void deleteTodo(Todo todo) {
        repositoryTodo.delete(todo);
    }


}
