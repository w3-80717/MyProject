package com.JewelleryServer.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Category;
import com.JewelleryServer.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService catService;


	@GetMapping
	public ResponseEntity<?> getAllCategory(){
		return null;
	}

	@GetMapping("/{cid}")
	public ResponseEntity<?> getCategory(@PathVariable("cid") int cid){
		return null;
	}

	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Category cat){
		return null;
	}

	@PutMapping("/{cid}")
	
		public ResponseEntity<?> updateCategory(@PathVariable("cid") int cid
				, @RequestBody Category cat){
		return null;
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<?> deleteCategory(@PathVariable("cid") int cid){
		return null;
	}



}