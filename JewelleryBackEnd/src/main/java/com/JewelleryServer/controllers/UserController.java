package com.JewelleryServer.controllers;

import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
    originPatterns = { "https://localhost", "http://localhost:3000", "*" },
    allowCredentials = "true",
    allowedHeaders = "*"
)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.register(user) != null) {
            return ResponseEntity.ok(
                "{ \"message\":\"Register successfully\"}"
            );
        }

        return ResponseEntity.badRequest()
            .body(
                "{ \"message\":\"Registration Failed, Email already exists!\"}"
            );
    }
}
