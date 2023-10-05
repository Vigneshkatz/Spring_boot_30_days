package com.katziio.emailverify.controller;

import com.katziio.emailverify.entity.User;
import com.katziio.emailverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user) {
        user.setActive(false);
        System.out.println(user.getEmail());
        return this.userService.saveUser(user);
    }

    @PostMapping("/confirm-account")
    public User confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return this.userService.verifyAccount(confirmationToken);
    }

}
