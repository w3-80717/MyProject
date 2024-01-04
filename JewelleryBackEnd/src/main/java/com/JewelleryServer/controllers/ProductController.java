package com.JewelleryServer.controllers;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Response<?> createProduct(@RequestBody Product product, HttpSession session) {
		// check if request is from admin user
		// service layer: validate and save the product
		// else
		// return 403 unauthorised response

		/*
		 * check karne ke liye ki user admin hai ya customer: pehele session me se user
		 * nikalte hai
		 */
		/*
		 * to check if the user is admin or customer: get the user stored in the session
		 */
		User user = (User) session.getAttribute("curUser");
		// if user is null means not logged in
		// if user role is not admin means user is not allowed to create product
		if (user == null) {
			return Response.error("Please login");
		} else if (!user.getRole().equals("admin")) {
			return Response.error("Unauthorized");
		}
		prodService.saveProduct(product);
		return Response.success("Saved Product Successfully");
	}

	@GetMapping("/{productId}")
	public Response<?> getProductById(@PathParam("productId") int productId) {
		
		Product p = null;// service
		return Response.success(p);

	}

}
