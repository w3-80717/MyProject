package com.JewelleryServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JewelleryServer.pojo.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
