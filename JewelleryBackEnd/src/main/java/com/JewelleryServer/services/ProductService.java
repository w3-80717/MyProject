
package com.JewelleryServer.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.CategoryDao;
import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.dao.SubCategoryDao;
import com.JewelleryServer.pojo.Category;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.ProductDto;
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
	

	public Product saveProduct(ProductDto product) throws IOException{
		Product p = new Product();
		p.setPname(product.getPname());
		p.setPrice(product.getPrice());
		p.setCategory(catDao.findById(product.getCid()).get());
		p.setSubCategory(subCatDao.findById(product.getCid()).get());
		p.setImage("/api/images/"+product.getImage().getOriginalFilename());
		
		String directory = System.getProperty("user.home")+"/uploads/";
		new File(directory).mkdir();
		product.getImage().transferTo(Paths.get(directory+product.getImage().getOriginalFilename()));
		return prodDao.save(p);
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return prodDao.findById(productId).get();
	}

	public Product updateProduct(int productId, Product productDto) {
		// TODO Auto-generated method stub
		Product p = prodDao.findById(productId).get();
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
