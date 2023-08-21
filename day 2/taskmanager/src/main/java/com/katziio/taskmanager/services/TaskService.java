package com.katziio.taskmanager.services;

import com.katziio.taskmanager.model.Task;
import com.katziio.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService extends RuntimeException{

    private final TaskRepository taskRepository;

    @Autowired
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }

    @Transactional(readOnly = true)
    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }
}
