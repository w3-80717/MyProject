
package com.JewelleryServer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JewelleryServer.pojo.Category;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.SubCategory;

public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.category=:c and p.subCategory=:sc")
	List<Product> findAllByCategoryAndSubCategory(Category c, SubCategory sc);

}