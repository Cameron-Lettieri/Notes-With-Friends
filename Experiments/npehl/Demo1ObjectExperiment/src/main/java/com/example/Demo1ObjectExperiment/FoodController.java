package com.example.Demo1ObjectExperiment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController
{
	@GetMapping("/food")
	public String getFoodName()
	{
		return (new Food("Apples").getName());
	}
	
	@GetMapping("/foodList")
	public Food[] getFoodList()
	{
		Food[] list = new Food[5];
		list[0] = new Food("Apple");
		list[1] = new Food("Chips");
		list[2] = new Food("Tacos");
		list[3] = new Food("Pizza");
		list[4] = new Food("Carrots");
		
		return list;
	}
	
	@GetMapping("/food/{name}")
	public String FoodPathVariable(@PathVariable("name") String name)
	{
		return (new Food(name).getName());
	}
}
