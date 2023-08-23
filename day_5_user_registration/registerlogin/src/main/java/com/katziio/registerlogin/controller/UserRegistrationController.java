package com.katziio.registerlogin.controller;

import com.katziio.registerlogin.entity.User;
import com.katziio.registerlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String password)
    {
        User user = userRepository.findByUserName(userName);
        if(user!=null && user.getPassword().equals(password))
        {
            return ResponseEntity.ok("Login successful");
        }
        else {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }
}
