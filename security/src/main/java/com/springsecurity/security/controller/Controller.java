package com.springsecurity.security.controller;

import com.springsecurity.security.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/Students")
    public List<User> getStudentsList(){
        List<User> users = new ArrayList<>();
        users.add(new User("Vignesh","1234"));
        users.add(new User("katziio","1234"));
        return users;
    }
    @RequestMapping("/addStudents")
    public User addUser(@RequestBody User user)
    {
        return user;
    }

}
