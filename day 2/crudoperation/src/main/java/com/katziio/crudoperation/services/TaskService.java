package com.katziio.crudoperation.services;

import com.katziio.crudoperation.data.models.Task;
import com.katziio.crudoperation.data.payloads.request.TaskRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public interface TaskService {
    CompletableFuture<Task> createTask(TaskRequest taskRequest);
    CompletableFuture<Optional<Task>> updateTask(String id, TaskRequest taskRequest);
    CompletableFuture<Optional<Task>> deleteTask(String id);
    CompletableFuture<Optional<Task>> getTask(String id);

}