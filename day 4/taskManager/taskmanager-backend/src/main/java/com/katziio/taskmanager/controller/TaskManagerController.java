package com.katziio.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskManager")
public class TaskManagerController {

    private UserService userService;
    private TaskService taskService;

    //    add user
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        boolean status = userService.addUser(user);
        if (status) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    //    delete User
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> addUser(@RequestParam Long id) {
        boolean status = userService.deleteUser(id);
        if (status) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    //    Add tasks
    @PostMapping("/addTask")
    public ResponseEntity<String> addUser(@RequestBody Task task) {
        boolean status = userService.addTask(task);
        if (status) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    //    delete Task
    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> addUser(@RequestParam Long task_id, @RequestBody String task_description) {
        boolean status = userService.deleteTask(task_id,task_description);
        if (status) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

}
