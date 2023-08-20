package com.katziio.crudoperation.data.payloads.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;
    private boolean isCompleted;
}