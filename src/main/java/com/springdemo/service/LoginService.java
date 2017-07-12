package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.entities.User;

public interface LoginService {
   User getUserByName(String Name);
    
}