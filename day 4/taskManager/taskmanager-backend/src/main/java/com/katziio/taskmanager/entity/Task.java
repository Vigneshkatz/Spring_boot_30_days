package com.katziio.taskmanager.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "task_description")
    private String taskDescription;

}
