package com.example.demo.models;


import jakarta.persistence.*;
@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String title;
private boolean completed;
// Getters et setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public boolean isCompleted() { return completed; }
public void setCompleted(boolean completed) { this.completed = completed; }
}