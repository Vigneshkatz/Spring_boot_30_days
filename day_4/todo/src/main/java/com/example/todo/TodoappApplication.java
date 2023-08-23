package com.example.todo;

import com.example.todo.entity.Todo;
import com.example.todo.entity.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TodoappApplication implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TodoRepository todoRepository;
	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setId(1L);
		user.setUsername("Vignesh");
		user.setPassword("Something");
//		User user2 = new User();
//		user.setId(2L);
//		user.setUsername("Abdul");
//		user.setPassword("Something");

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setContent("Be A developer Brother");
		user.getTodoList().add(todo);
//		todo.setId(2L);
//		todo.setContent("Be A Developer Dude");
//		user.getTodoList().add(todo);

		todoRepository.save(todo);

		userRepository.save(user);
//		userRepository.save(user2);
	}
}
