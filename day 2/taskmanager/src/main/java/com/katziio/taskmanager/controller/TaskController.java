package com.katziio.taskmanager.controller;

import com.katziio.taskmanager.model.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.katziio.taskmanager.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
@AllArgsConstructor
@NoArgsConstructor
public class TaskController {
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTask(){
        return taskService.getTasks();
    }

}
