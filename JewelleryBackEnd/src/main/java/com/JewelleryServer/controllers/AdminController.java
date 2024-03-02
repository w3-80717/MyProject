package com.JewelleryServer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.ProductDto;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private ProductService prodService;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(prodService.getAllProducts());
	}

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto, HttpSession session) {
		User u = (User) session.getAttribute("curUser");
		if (u != null && u.getRole().equals("admin")) {
			prodService.saveProduct(productDto);
		} else {
			return new ResponseEntity<String>("you dont have access", HttpStatus.UNAUTHORIZED);
		}

		// check if request is from admin user
		// service layer: validate and save the product
		// else
		// return 403 unauthorised response
		return ResponseEntity.ok("success");
	}

	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") int productId, HttpSession session) {
		User u = (User) session.getAttribute("curUser");
		if (u != null && u.getRole().equals("admin")) {
			Product p = prodService.getProductById(productId);// service layer: get the product by id
			return ResponseEntity.ok(p);
		} else {
			return new ResponseEntity<String>("you dont have access", HttpStatus.UNAUTHORIZED);
		}

	}

	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable("productId") int productId, @RequestBody Product productDto,
			HttpSession session) {
		User u = (User) session.getAttribute("curUser");
		if (u != null && u.getRole().equals("admin")) {
			prodService.updateProduct(productId, productDto);
		} else {
			return new ResponseEntity<String>("you dont have access", HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("success");
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("productId") int productId, HttpSession session) {
		User u = (User) session.getAttribute("curUser");
		if (u == null || !u.getRole().equals("admin")) {
			return new ResponseEntity<String>("you dont have access", HttpStatus.UNAUTHORIZED);
		}
		int count = prodService.deleteById(productId);

		// Check if the deletion was successful
		if (count > 0) {
			// Return a ResponseEntity with a success status and a message
			return ResponseEntity.ok("Product deleted successfully");
		} else {
			// If deletion failed or no rows were affected, return a not found status
			return ResponseEntity.notFound().build();
		}
	}
}
