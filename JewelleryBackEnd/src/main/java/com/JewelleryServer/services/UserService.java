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
	
	
}
