package com.katziio.files.controller;

import com.katziio.files.entity.User;
import com.katziio.files.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/upload")
    public List<User> uploadSimple(@RequestParam("file") MultipartFile file) {

        return this.userService.readFile(file);
    }

    @RequestMapping(path = "/employees")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        userService.writeEmployeesToCsv(servletResponse.getWriter());
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
