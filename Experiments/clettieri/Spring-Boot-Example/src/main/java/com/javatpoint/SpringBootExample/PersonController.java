package com.javatpoint.SpringBootExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Transfers code to html
@RestController
public class PersonController {
	
	// http://localhost:8080/person
	//Names url
	//Object
	@GetMapping("/person")
	public Person getPerson()
	{	
		return new Person("Cameron", "Lettieri");
	
	}
	
	//List of Objects
	@GetMapping("/persons")
	public List<Person> getPersons()
	{
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Jeff", "Bezos"));
		persons.add(new Person("Bill", "Gates"));
		persons.add(new Person("Steve", "Jobs"));
		return persons;
	}
	
	//Path Variable
	@GetMapping("/person/{firstName}/{lastName}")
	public Person personPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName)
	{
		return new Person(firstName, lastName);
	}
}
