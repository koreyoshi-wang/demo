package com.springdemo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springdemo.entities.User;
import com.springdemo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public User getUserByName(String name){
		User user = new User();
		String sql = "select * from user where username=?";  
        String[] args = new String[] {name};  
        user = (User)jdbcTemplate.queryForObject(sql, args,new BeanPropertyRowMapper(User.class));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		
		List<User> userList = new ArrayList<User>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			User user = new User();
			user.setUsername((String) row.get("username"));
			user.setPassword((String) row.get("password"));
			userList.add(user);
		}
		return userList;
	}

	@Override
	public boolean queryUserExist(String username) {
		// TODO Auto-generated method stub
		if (!username.equals(null)){
			String sql = "select count(*) from user where username=?";
			int userCount = jdbcTemplate.queryForObject(sql, new String[]{username}, Integer.class);
			if (userCount == 0){
				return false;
			}
			else{
				return true;
			}
		}
		return true;
	}

	@Override
	public int addUser(String username, String password) {
		// TODO Auto-generated method stub
		if (username != null && password != null){
			String sql = "insert into user (username, password) values(?,?)";
			int returnCode = jdbcTemplate.update(sql, new String[]{username, password});
			return returnCode;
		}else{
			return 0;
		}
	}

	@Override
	public int deleteUser(String username) {
		// TODO Auto-generated method stub
		String sql = "delete from user where username=?";
		int returnCode = jdbcTemplate.update(sql, new String[]{username});
		return returnCode;
	}	
}
