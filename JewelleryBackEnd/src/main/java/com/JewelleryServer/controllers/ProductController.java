package com.JewelleryServer.controllers;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.Response;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.ProductService;
@RestController
@RequestMapping("/product")

public class ProductController {
	@Autowired
    private ProductService prodService;
	
	@PostMapping
    public ResponseEntity<?> createProduct(@RequestBody  Product productDto, HttpSession session){
	   User u = (User) session.getAttribute("curUser");
	   if(u!=null&&u.getRole().equals("admin")) {
		   prodService.saveProduct(productDto);
	   }else {
		   return new ResponseEntity("you dont have access", HttpStatus.UNAUTHORIZED);
	   }
		  
		
		//check if request is from admin user
   		 // service layer: validate and save the product
   	 // else
   		 // return 403 unauthorised response
   	 return ResponseEntity.ok("success");
    }
    
	  @GetMapping("/{productId}")
	    public ResponseEntity<?> getProductById(@PathVariable("productId") int productId) {
	   	
	   	Product p = prodService.getProductById(productId);// service layer: get the product by id
	   	 return ResponseEntity.ok(p);
	   	 
	   }

      @PutMapping("/{productId}")
      public ResponseEntity<?> updateProduct(@PathVariable("productId") int productId, 
    		  @RequestBody Product productDto, HttpSession session){
    	  User u = (User) session.getAttribute("curUser");
    	  if(u!=null&&u.getRole().equals("admin")) {
    		  
   		  Product p= prodService.updateProduct(productId,productDto );
   	   }else {
   		   return new ResponseEntity("you dont have access", HttpStatus.UNAUTHORIZED);
   	   }
    	  return ResponseEntity.ok("success");
      }
      
      
}
