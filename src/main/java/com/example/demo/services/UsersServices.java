package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersServices 
{
	//adds new user to database
	String addUser(Users user);
	//checks email is already present in the database or not
	boolean emailExists(String email);
	//validates user's credentials
	boolean validate(String email, String password);
	//get user's role by providing email
	String getUserRole(String email);
	//gets user by providing email
	Users getUser(String email);
	
	//save updated user to database
	String updateUser(Users user);

}
