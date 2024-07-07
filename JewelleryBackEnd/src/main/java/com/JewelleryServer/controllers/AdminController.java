package com.JewelleryServer.controllers;

import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.ProductDto;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.ProductService;
import com.JewelleryServer.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(
    originPatterns = { "https://localhost", "http://localhost:3000", "*" },
    allowCredentials = "true",
    allowedHeaders = "*"
)
public class AdminController {

    @Autowired
    private ProductService prodService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);

        if (u != null && u.getRole().equals("admin")) {
            return ResponseEntity.ok(prodService.getAllProducts());
        } else {
            return new ResponseEntity<String>(
                "You don't have access",
                HttpStatus.UNAUTHORIZED
            );
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
        @ModelAttribute ProductDto productDto,
        @RequestHeader("Authorization") String sessionId
    ) throws Exception {
        User u = validateAndGetUser(sessionId);

        if (u != null && u.getRole().equals("admin")) {
            prodService.saveProduct(productDto);
            return ResponseEntity.ok("Product created successfully");
        } else {
            return new ResponseEntity<String>(
                "You don't have access to create a product.",
                HttpStatus.UNAUTHORIZED
            );
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(
        @PathVariable("productId") int productId,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);

        if (u != null && u.getRole().equals("admin")) {
            Product p = prodService.getProductById(productId);
            if (p != null) {
                return ResponseEntity.ok(p);
            } else {
                return new ResponseEntity<String>(
                    "Product not found",
                    HttpStatus.NOT_FOUND
                );
            }
        } else {
            return new ResponseEntity<String>(
                "You don't have access",
                HttpStatus.UNAUTHORIZED
            );
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(
        @PathVariable("productId") int productId,
        @RequestBody Product productDto,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);

        if (u != null && u.getRole().equals("admin")) {
            prodService.updateProduct(productId, productDto);
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return new ResponseEntity<String>(
                "You don't have access",
                HttpStatus.UNAUTHORIZED
            );
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(
        @PathVariable("productId") int productId,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);

        if (u != null && u.getRole().equals("admin")) {
            int count = prodService.deleteById(productId);
            if (count > 0) {
                return ResponseEntity.ok("Product deleted successfully");
            } else {
                return new ResponseEntity<String>(
                    "Product not found",
                    HttpStatus.NOT_FOUND
                );
            }
        } else {
            return new ResponseEntity<String>(
                "You don't have access",
                HttpStatus.UNAUTHORIZED
            );
        }
    }

    // Helper method to validate session ID and retrieve user information
    private User validateAndGetUser(String sessionId) {
        // Implement logic to validate session ID and retrieve user information from SessionManager
        return SessionManager.getSession(sessionId);
    }
}
