package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Users;


@Controller
public class NavController 
{
	@GetMapping("/login")
	public String login() 
	{
		
		return "login";
	}
	@GetMapping("/registration")
	public String registration(@ModelAttribute Users user) 
	{		
		return "registration";
	}
	@GetMapping("/addCourse")
	public String addCourse() {
		return "createCourse";
	}
	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}
	@GetMapping("/viewAllCourses")
	public String viewAllCourses() {
		return "courses";
	}
	
	@GetMapping("/myCourses")
	public String myCourses() {
		return "myCourses";
	}
	@GetMapping("/viewCourses")
	public String viewCourses() {
		return "courses";
	}
	
	

}
