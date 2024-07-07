package com.JewelleryServer.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
    originPatterns = { "https://localhost", "http://localhost:3000", "*" },
    allowCredentials = "true",
    allowedHeaders = "*"
)
@RequestMapping("/api/images")
public class ImageController {

    @GetMapping("{image}")
    public ResponseEntity<?> getImage(@PathVariable String image) {
        String path = System.getProperty("user.home") + "/uploads/" + image;
        Path p = Paths.get(path);
        try {
            byte[] fileByteArr = Files.readAllBytes(p);
            return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileByteArr);
        } catch (IOException ioex) {
            return ResponseEntity.notFound().build();
        }
    }
}
