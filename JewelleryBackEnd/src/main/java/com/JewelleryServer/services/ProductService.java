
package com.JewelleryServer.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.JewelleryServer.dao.CategoryDao;
import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.dao.SubCategoryDao;
import com.JewelleryServer.pojo.Category;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.SubCategory;

@Transactional
@Service
public class ProductService {

	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private CategoryDao catDao;
	@Autowired
	private SubCategoryDao subCatDao;
	

	public Product saveProduct(@RequestBody Product product) {
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

	public int deleteById(int productId) {
		prodDao.deleteById(productId);
		return 1;
	}

	public List<Product> getAllProducts() {
		return prodDao.findAll();
	}

	public List<Product> getAllProductsByCatIdSubCatId(int cid, int sid) {
		Category c = catDao.findById(cid).get();
		SubCategory sc = subCatDao.findById(sid).get();
		return prodDao.findAllByCategoryAndSubCategory(c, sc);
	}

}
