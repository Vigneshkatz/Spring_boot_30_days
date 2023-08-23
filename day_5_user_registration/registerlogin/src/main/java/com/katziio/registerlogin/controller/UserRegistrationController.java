package com.katziio.registerlogin.controller;

import com.katziio.registerlogin.entity.User;
import com.katziio.registerlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        User addUser = userRepository.save(user);
        return user;
    }

    @GetMapping("/login")
    public User login(@RequestBody User user)
    {
        userRepository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        return  user;
    }
}
