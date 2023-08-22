create database day_4_taskmanager;
use day_4_taskmanager;

CREATE TABLE tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    task_description TEXT NOT NULL
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    task_id INT,
    FOREIGN KEY (task_id) REFERENCES tasks(id)
);
