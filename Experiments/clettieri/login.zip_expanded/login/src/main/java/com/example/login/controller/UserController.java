package com.example.login.controller;

import java.util.Objects;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.service.UserService;

@Controller
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/login")
	public Stirng login(@ModelAttribute("user") User user)
	{
		User aUser =  userService.login(user.getUsername(), user.getPassword());
		System.out.print(aUser);
		if (Objects.nonNull(aUser))
		{
			return "redirect:/";
		}
		else
		{
			return "redirect:/login";
		}
	}

}
