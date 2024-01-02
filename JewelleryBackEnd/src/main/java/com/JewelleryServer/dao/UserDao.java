package com.JewelleryServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JewelleryServer.pojo.User;

public interface UserDao extends JpaRepository<User, Integer>{
// jpa s
	public User findByEmail(String email);
 
}
