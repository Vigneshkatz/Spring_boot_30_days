package com.katziio.firebase.controller;


import com.katziio.firebase.entity.User;
import com.katziio.firebase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    //  exception handiling

    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws Exception{
        return this.userService.createUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String documentId) throws Exception{
        return this.userService.getUser(documentId);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) throws Exception{
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public String updateUser(@RequestParam String documentId) throws Exception{
        return this.userService.deleteUser(documentId);
    }

//    Test

    @GetMapping("/test")

    public ResponseEntity<String> testEndPoint(){
        return ResponseEntity.ok("Working fine");
    }


}
