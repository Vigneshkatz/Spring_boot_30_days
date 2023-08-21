package com.example.demo.controller;

import com.example.demo.entity.UserDetails;
import com.example.demo.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class ControllerClass {

    @Autowired
    ServiceClass service;

    @GetMapping("/getDetails")
    public List<UserDetails> getDetails() {
        return service.findall();
    }

    @PostMapping("/addDetails")
    public ResponseEntity<String> addDetails(@RequestBody UserDetails userDetails) {
        System.out.printf(userDetails.getName());
        service.addUser(userDetails);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteDetails")
    public ResponseEntity<String> deleteDetails(@RequestParam Long id) {
        int result = service.deleteUser(id);
        if (result == 1) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateDetails/{id}")
    public ResponseEntity<String> updateDetails(
            @PathVariable Long id,
            @RequestBody UserDetails userDetails) {
        if (service.updateUser(id, userDetails)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
