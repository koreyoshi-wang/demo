package com.springdemo.service;

import com.springdemo.entities.User;

import java.util.List;

public interface LoginService {
	
	User getUserByName(String name);
	
	List<User> getAllUsers();
	
	boolean queryUserExist(String username);
	
	int addUser(String username, String password);
	
	int deleteUser(String username);
}