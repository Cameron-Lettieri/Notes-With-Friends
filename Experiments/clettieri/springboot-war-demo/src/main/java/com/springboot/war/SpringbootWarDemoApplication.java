package com.springboot.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

//Opens server externally through computer files
public class SpringbootWarDemoApplication {
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Springboot WAR demo";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWarDemoApplication.class, args);
	}

}
