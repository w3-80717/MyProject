package com.JewelleryServer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Credential;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	public UserService userService;

	// @postMapping is used to handle the post req to /login , in this method
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Credential cr, HttpSession httpSession) {
		// first it fetches credential from body , if the credential is correct valid
		// then stores the user inf in session,
		// then return successful response // then set status sucessful correct then its
		// successful if incorrect then its failed error
		// service layer: authentication and store in session
		User user = userService.authenticate(cr);
		if (user != null) {
			httpSession.setAttribute("curUser", user);
			return ResponseEntity.ok("{\"status\":\"success\",\"role\":\""+user.getRole()+"\"}");
		}
		return new ResponseEntity<String>("Login Failed", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> signout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("Logout success");
	}

}
