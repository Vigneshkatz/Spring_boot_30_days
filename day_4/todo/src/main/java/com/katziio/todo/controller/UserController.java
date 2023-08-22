package com.katziio.todo.controller;

import com.katziio.todo.entity.User;
import com.katziio.todo.repository.TodoRepository;
import com.katziio.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/{userid}")
    public User getUserById(@PathVariable Long userid)
    {
        return userRepository.findById(userid).orElseThrow(()-> new NoSuchElementException());
    }
}
