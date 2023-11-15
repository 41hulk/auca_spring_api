package com.example.registrationspringapi;

import com.example.registrationspringapi.model.Student;
import com.example.registrationspringapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RegistrationSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationSpringApiApplication.class, args);
	}

}
