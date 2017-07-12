package com.springdemo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springdemo.entities.User;
import com.springdemo.service.LoginService;

@Service
public class LoginServicImpl implements LoginService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public User getUserByName(String name){
		System.out.println(name);
		User user = new User();
		String sql = "select * from user where username=?";  
        String[] args = new String[] {name};  
        user = (User)jdbcTemplate.queryForObject(sql, args,new BeanPropertyRowMapper(User.class));
		return user;
	}	
}
