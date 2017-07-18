package com.springdemo.service;

import java.util.List;

import com.springdemo.entities.User;

public interface LoginService {
   User getUserByName(String Name);

   List<User> getAllUsers();

   boolean queryUserExist(String username);

   int addUser(String username, String password);

   int deleteUser(String username);
    
}