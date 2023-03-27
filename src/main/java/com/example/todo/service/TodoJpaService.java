package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.TodoJpaRepository;

import java.util.*;

@Service
public class TodoJpaService implements TodoRepository{

    @Autowired 
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodos(){
        List<Todo> todolists = todoJpaRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>(todolists);
        return todos;

    }
    
    @Override
    public Todo addTodo(Todo todo){

        Todo addedTodo = todoJpaRepository.save(todo);
        return addedTodo;

    }

    @Override
    public Todo getTodoById(int id){
        try{
            Todo currentTodo = todoJpaRepository.findById(id).get();
            return currentTodo;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        

    }
    
    @Override
    public Todo updateTodo(int id, Todo todo){
        try{
            Todo existingTodo = todoJpaRepository.findById(id).get();

            if(todo.getTodo() != null){
                existingTodo.setTodo(todo.getTodo());
            }

            if(todo.getPriority() != null){
                existingTodo.setPriority(todo.getPriority());
            }

            if(todo.getStatus() != null){
                existingTodo.setStatus(todo.getStatus());
            }

            todoJpaRepository.save(existingTodo);

            return existingTodo;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id){
        try{
            todoJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}