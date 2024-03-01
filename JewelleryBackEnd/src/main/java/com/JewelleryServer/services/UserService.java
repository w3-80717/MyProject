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
	public Object register(User user) {
		user.setRole("customer");
		// TODO Auto-generated method stub
		User checkUser = userDao.findByEmail(user.getEmail());
		if(checkUser==null) {
			return userDao.save(user);
		}
		return null;
	}
	
	
}
