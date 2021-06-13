package com.portfolio.management;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portfolio.management.controller.TodoController;

@SpringBootApplication
public class TodoManagementSpringBoot2Application {

	public static void main(String[] args) {
		new File(TodoController.uploadDirectory).mkdir();
		SpringApplication.run(TodoManagementSpringBoot2Application.class, args);
	}
}
