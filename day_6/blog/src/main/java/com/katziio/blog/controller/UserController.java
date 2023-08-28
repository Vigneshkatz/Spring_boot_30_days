package com.katziio.blog.controller;

import com.katziio.blog.dto.UserDTO;
import com.katziio.blog.entity.User;
import com.katziio.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/login")
    public UserDTO getUserByEmailPassword(@RequestParam String email, @RequestParam String password) {
        return userService.getUserByEmailPassword(email, password);
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public UserDTO deleteUserById(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUserById(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUserById(userId, user);
    }
}
