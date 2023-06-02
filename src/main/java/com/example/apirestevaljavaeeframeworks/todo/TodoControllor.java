package com.example.apirestevaljavaeeframeworks.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoControllor {
    @Autowired
    TodoService service;

    //--------------------getAllTodos------------------------//
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        List<Todo> todos = service.getAllTodos();
        return todos;
    }
    //--------------------getStudentByI------------------------//
    @GetMapping("/todos/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable("todoId") int id){
        Optional<Todo> todoOptional = service.getTodo(id);
        if (todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            return ResponseEntity.ok(todo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo inixistant");
        }
    }

    //--------------------addTodo------------------------//
    @PostMapping("/todos")
    public ResponseEntity<String> addTodo(@RequestBody Todo todo){
        Todo newTodo = service.saveTodo(todo);
        return ResponseEntity.ok("Todo added");
    }

    //--------------------updateTodoByID------------------------//
    @PutMapping("/todos/{todoId}")
    public ResponseEntity<String> updateTodo(@PathVariable("todoId") int id, @RequestBody Todo todo){
        Optional<Todo> todoOptional = service.getTodo(id);
        if (todoOptional.isPresent()){
            todo.setId(id);
            service.saveTodo(todo);
            return ResponseEntity.ok("Updated Todo!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //--------------------deleteTodoByID------------------------//
    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable("todoId") int id){
        Optional<Todo> todoOptional = service.getTodo(id);
        if (todoOptional.isPresent()){
            Todo deleteTodo = todoOptional.get();
            service.deleteTodo(deleteTodo);
            return ResponseEntity.ok("Deleted Todo!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
