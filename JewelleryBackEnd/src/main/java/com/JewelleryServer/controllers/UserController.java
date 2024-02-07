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
	public Response<?>register(@RequestBody User user){
	
		if(userService.register(user)!=null) {
		return Response.success("Register successfully");
		
	}
	
    return Response.error("Registration Failed. Email already registered");
	}	
}
