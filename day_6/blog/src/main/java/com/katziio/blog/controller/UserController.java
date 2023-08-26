package com.katziio.blog.controller;

import com.katziio.blog.dto.UserDTO;
import com.katziio.blog.entity.User;
import com.katziio.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @GetMapping("/Users")
    public List<User> getAllUser()
    {
        return this.userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId)
    {
        return this.userService.getUserById(userId);
    }

    @DeleteMapping("deleteUser/{userId}")
    public UserDTO deleteUserById(@PathVariable Long userId)
    {
        return this.userService.deleteUserById(userId);
    }

    @PutMapping("/updateUser/{userId}")
    public UserDTO updateUserByUserId(@PathVariable Long userId,@RequestBody User user)
    {
        return this.userService.updateUserById(userId,user);
    }
}
