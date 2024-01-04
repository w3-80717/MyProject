package com.JewelleryServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.pojo.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao prodDao;
	
	public Product saveProduct(Product product) {
		return prodDao.save(product);
	}
	
}
