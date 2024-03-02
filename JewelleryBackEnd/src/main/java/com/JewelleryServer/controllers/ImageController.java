package com.JewelleryServer.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

	@GetMapping("{image}")
	public ResponseEntity<?> getImage(@PathVariable String image){
		String path = System.getProperty("user.home")+"/uploads/"+image;
		Path p = Paths.get(path);
		try {
			byte[] fileByteArr = Files.readAllBytes(p);
			return ResponseEntity
					.status(HttpStatus.OK) // set status as OK
					.contentType(MediaType.IMAGE_JPEG) // response Content-Type = image/jpeg
					.body(fileByteArr); // body is the image byte array
		}catch(IOException ioex) {
			return ResponseEntity.notFound().build();
		}
	}
}
