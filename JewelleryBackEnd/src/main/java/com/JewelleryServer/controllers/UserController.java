package com.JewelleryServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Response;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/register") 
	public Response<?> register(@RequestBody User user){
	//service layer:check if not duplicate and then save user.
		
		// if email is already registered then register will return null
		// else register new user successfully
		
		if(userService.register(user)!=null) {
			return Response.success("Registered Successfully");
		}
		
		return Response.error("Registration Failed. Email already registered");
	}
   
	
}
