package com.JewelleryServer.controllers;

import com.JewelleryServer.pojo.Cart;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.pojo.WishList;
import com.JewelleryServer.services.CartService;
import com.JewelleryServer.services.ProductService;
import com.JewelleryServer.services.WishListService;
import com.JewelleryServer.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/customer")
@CrossOrigin(
    originPatterns = { "https://localhost", "http://localhost:3000", "*" },
    allowCredentials = "true",
    allowedHeaders = "*"
)
public class CustomerController {

    @Autowired
    private ProductService prodService;

    @Autowired
    private CartService cartService;

    @Autowired
    private WishListService wishListService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(prodService.getAllProducts());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId) {
        Product p = prodService.getProductById(productId);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/product/{cid}/{sid}")
    public ResponseEntity<?> getProductByCategoryAndSubCategory(
        @PathVariable int cid,
        @PathVariable int sid
    ) {
        try {
            List<Product> products = prodService.getAllProductsByCatIdSubCatId(
                cid,
                sid
            );
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addcart/{pid}/{qty}")
    public ResponseEntity<?> addProductToCart(
        @PathVariable int pid,
        @PathVariable int qty,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            Cart c = cartService.addProductToCart(pid, qty, u);
            if (c == null) {
                return ResponseEntity.badRequest().body("Bad Request");
            } else {
                return ResponseEntity.ok(c);
            }
        }
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            Cart c = cartService.getCart(u);
            if (c == null) return ResponseEntity.badRequest()
                .body("Bad Request");
            else return ResponseEntity.ok(c);
        }
    }

    @DeleteMapping("/cart/{ciid}")
    public ResponseEntity<?> deleteItem(
        @PathVariable int ciid,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            Cart c = cartService.deleteItem(ciid, u);
            if (c == null) return ResponseEntity.badRequest()
                .body("Bad Request");
            else return ResponseEntity.ok(c);
        }
    }

    @PostMapping("/addwishlist/{pid}")
    public ResponseEntity<?> addProductToWishList(
        @PathVariable int pid,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            WishList wl = wishListService.addProductToWishList(pid, u);
            if (wl == null) {
                return ResponseEntity.badRequest().body("Bad Request");
            } else {
                return ResponseEntity.ok(wl);
            }
        }
    }

    @GetMapping("/wishlist")
    public ResponseEntity<?> getWishList(
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            WishList wl = wishListService.getWishList(u);
            if (wl == null) return ResponseEntity.badRequest()
                .body("Bad Request");
            else return ResponseEntity.ok(wl);
        }
    }

    @DeleteMapping("/wishlist/{wiid}")
    public ResponseEntity<?> deleteWishListItem(
        @PathVariable int wiid,
        @RequestHeader("Authorization") String sessionId
    ) {
        User u = validateAndGetUser(sessionId);
        if (u == null) {
            return new ResponseEntity<String>(
                "Not logged in",
                HttpStatus.UNAUTHORIZED
            );
        } else {
            WishList wl = wishListService.deleteWishListItem(wiid, u);
            if (wl == null) return ResponseEntity.badRequest()
                .body("Bad Request");
            else return ResponseEntity.ok(wl);
        }
    }

    // Helper method to validate session ID and retrieve user information
    private User validateAndGetUser(String sessionId) {
        // Implement logic to validate session ID and retrieve user information from SessionManager
        return SessionManager.getSession(sessionId);
    }
}
