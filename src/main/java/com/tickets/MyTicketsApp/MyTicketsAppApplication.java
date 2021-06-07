package com.tickets.MyTicketsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.tickets.MyTicketsApp.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class MyTicketsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTicketsAppApplication.class, args);
	}

}
