package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersServices
{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) 
	{
		repo.save(user);
		return "User added";
	}

	@Override
	public boolean emailExists(String email) {

		if(repo.findByEmail(email) == null)
		{
			return false;
		}
		else {
			return true;
		}

	}

	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			Users user = repo.findByEmail(email);
			String db_password = user.getPassword();
			if(password.equals(db_password))
			{
				System.out.println("Password matches");
				return true;
			}
			else {
				System.out.println("Password is not matched");
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public String getUserRole(String email) {
		Users user = repo.findByEmail(email);	
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public String updateUser(Users user) {
		repo.save(user);
		return "student updated successfully!";
	}

}
