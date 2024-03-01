package com.JewelleryServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JewelleryServer.pojo.Cart;
import com.JewelleryServer.pojo.User;

public interface CartDao extends JpaRepository<Cart, Integer> {

	public Cart findByUser(User u);
}
