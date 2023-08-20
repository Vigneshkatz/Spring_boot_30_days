package com.katziio.userregistration.controller;

import com.katziio.userregistration.dto.UserDTO;
import com.katziio.userregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//rest app
@RestController
//frontend
@CrossOrigin("*")
//path
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/save")// we are posting the value so postMapping
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }
}
