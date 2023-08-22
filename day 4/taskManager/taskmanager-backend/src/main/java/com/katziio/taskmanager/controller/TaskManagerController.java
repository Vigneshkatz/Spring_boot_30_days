package com.katziio.taskmanager.controller;

import com.katziio.taskmanager.entity.Task;
import com.katziio.taskmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskManager")
public class TaskManagerController {

    @Autowired
    private UserService userService;
    @Autowired
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
    @DeleteMapping("/deleteUser/{{id}}")
    public ResponseEntity<String> addUser(@PathVariable Long id) {
        boolean status = userService.deleteUser(id);
        if (status) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    //    Add tasks
    @PostMapping("/{user_id}/tasks")
    public ResponseEntity<String> addTaskToUser(@PathVariable Long user_id, @RequestBody Task task) {
        boolean status = userService.addTaskToUser(user_id, task);
        return status ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    //    delete Task
    @DeleteMapping("/{user_id}/tasks/{task_id}")
    public ResponseEntity<String> deleteTaskForUser(
            @PathVariable Long user_id,
            @PathVariable Long task_id,
            @RequestParam String task_description
    ) {
        boolean status = userService.deleteTaskForUser(user_id, task_id, task_description);
        return status ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
