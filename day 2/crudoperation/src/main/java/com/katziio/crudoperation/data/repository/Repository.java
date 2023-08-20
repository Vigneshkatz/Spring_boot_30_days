package com.katziio.crudoperation.data.repository;

import com.katziio.crudoperation.data.models.Task;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Repository<T extends Task> {
    CompletableFuture<T> save(T entity);

    CompletableFuture<Optional<T>> find(String id);

    CompletableFuture<Optional<T>> remove(String id);
}
