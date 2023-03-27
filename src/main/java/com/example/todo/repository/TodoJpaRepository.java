package com.example.todo.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository; //importing JPA Repository

import com.example.todo.model.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo,Integer>{

}