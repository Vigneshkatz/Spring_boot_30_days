package com.katziio.todo;

import com.katziio.todo.entity.Todo;
import com.katziio.todo.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setUsername("Vignesh");
		user.setPassword("Something");

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setContent("Be A developer Brother");
		user.getTodoList().add(todo);

	}
}
