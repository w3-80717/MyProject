
package com.JewelleryServer.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.pojo.Product;
@Transactional
@Service
public class ProductService {

	@Autowired
	private ProductDao prodDao;

	public Product saveProduct(Product product) {
		return prodDao.save(product);
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return prodDao.findById(productId).get();
	}

	public Product updateProduct(int productId, Product productDto) {
		// TODO Auto-generated method stub
		Product p = prodDao.findById(productId).get();
		
		p.setPname(productDto.getPname());
		p.setPrice(productDto.getPrice());
		
		return prodDao.save(p);
	}

	

	

}