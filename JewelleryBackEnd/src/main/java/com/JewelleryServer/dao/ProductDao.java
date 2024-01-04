package com.JewelleryServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JewelleryServer.pojo.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
