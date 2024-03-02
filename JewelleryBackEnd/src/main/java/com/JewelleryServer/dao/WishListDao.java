package com.JewelleryServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JewelleryServer.pojo.User;
import com.JewelleryServer.pojo.WishList;

public interface WishListDao extends JpaRepository<WishList, Integer> {

	public WishList findByUser(User u);
}
