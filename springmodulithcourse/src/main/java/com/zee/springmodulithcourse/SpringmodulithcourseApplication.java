package com.zee.springmodulithcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

import com.zee.springmodulithcourse.config.ModulithRegistrar;

@SpringBootApplication
@ImportRuntimeHints(ModulithRegistrar.class)
public class SpringmodulithcourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmodulithcourseApplication.class, args);
	}

}
