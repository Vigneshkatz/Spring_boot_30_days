package com.katziio.todo.entity;

import jakarta.persistence.Id;

public class Todo {

    @Id

    private Long id;
    private String content;
    private boolean completed = Boolean.FALSE;

    public Todo(Long id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
