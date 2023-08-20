package com.katziio.crudoperation.data.repository;

import java.util.concurrent.CompletableFuture;

public interface IdentityFactory {

    CompletableFuture<String> nextId();
}
