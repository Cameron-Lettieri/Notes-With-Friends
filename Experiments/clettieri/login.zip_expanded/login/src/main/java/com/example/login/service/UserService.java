package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.repository.UserRepository;
import com.example.login.domain.*;

@Service
public class UserService 
{
	
	@Autowired
	private UserRepository repo;
		
	public User login(String username, String password) 
	{
		User user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
	
}
