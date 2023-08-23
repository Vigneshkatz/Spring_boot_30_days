package com.example.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userdetails")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private Long id;

    private String username;
    private String password;

    @OneToMany
    private List<Todo> todoList = new ArrayList<>();
}
