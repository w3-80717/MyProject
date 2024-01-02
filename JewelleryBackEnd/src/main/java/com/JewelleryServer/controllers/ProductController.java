package com.JewelleryServer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Product;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/product")

public class ProductController {
	@PostMapping
    public ResponseEntity<?> createProduct(@RequestBody  Product productDto){
   	 // check if request is from admin user
   		 // service layer: validate and save the product
   	 // else
   		 // return 403 unauthorised response
   	 return ResponseEntity.ok("success");
    }
    
	  @GetMapping("/{productId}")
	    public ResponseEntity<?> getProductById(@PathParam("productId") int productId) {
	   	 
	   	 Product p = null;// service layer: get the product by id
	   	 return ResponseEntity.ok(p);
	   	 
	    }



}
