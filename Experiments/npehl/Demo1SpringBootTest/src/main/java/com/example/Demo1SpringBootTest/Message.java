package com.example.Demo1SpringBootTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Message
{
	@GetMapping("/welcome")
	public String message()
	{
		return "This is my initial Test for running a web app from Spring Boot";
	}
}
