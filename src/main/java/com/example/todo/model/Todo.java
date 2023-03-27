package com.example.todo.model;



import javax.persistence.*;


@Entity
@Table(name="todolist")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="todo")
    private String todo;

    @Column(name="priority")
    private String priority;

    @Column(name="status")
    private String status;

    public Todo(int id, String todo, String priority, String status){
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public Todo(){} //Default Constructor

    public void setId(int id){
        this.id = id;
    }

    public int getId(){ //Getter
        return this.id;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }

    public String getTodo(){ //Getter
        return this.todo;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public String getPriority(){ //Getter
        return this.priority;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){ //Getter
        return this.status;
    }

}