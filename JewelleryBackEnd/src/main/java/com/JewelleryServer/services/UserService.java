package com.JewelleryServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.UserDao;
import com.JewelleryServer.pojo.Credential;
import com.JewelleryServer.pojo.User;

//login registration used UserSerVice
@Service
public class UserService {
	@Autowired
	public UserDao userDao;
	public User authenticate(Credential cr) {
		User user = userDao.findByEmail(cr.getEmail());
		if(user != null && user.getPassword().equals(cr.getPassword()))
			return user;
		return null;
	}
	

	public User register(User user) {
		// first fetch user by email from the database
		User checkUser = userDao.findByEmail(user.getEmail());
		
		// second if user is not in database, then create user
		if(checkUser==null) {
			return userDao.save(user);
		}
		
		// third else user with same email is already in db, 
		// don't save return null, duplicate emails not allowed
		return null;
		
		
	}
	
	
}
