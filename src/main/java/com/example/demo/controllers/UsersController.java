package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entities.LoginData;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;

@Controller
public class UsersController 
{
	@Autowired
	UsersServices service;
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) 
	{
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus == false)
		{
			service.addUser(user);
			System.out.println("User is added");
			return "login";
		}
		else {
			System.out.println("User is already registered!!!");
			return "home";
		}
	}
	
	@PostMapping("/validate")
	public String validate(@ModelAttribute LoginData data) 
	{
		String email = data.getEmail();
		String password = data.getPassword();
		if(service.validate(email, password) == true)
		{
			String role = service.getUserRole(email);
			if(role.equals("student"))
			{
				return "studentHome";
			}
			else
			{
				return "trainerHome";
			}
		}
		
		return "login";
	}
	
	

}
