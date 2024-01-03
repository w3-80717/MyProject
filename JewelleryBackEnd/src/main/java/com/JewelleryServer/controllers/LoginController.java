package com.JewelleryServer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JewelleryServer.pojo.Credential;
import com.JewelleryServer.pojo.Response;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.UserService;


@RestController


public class LoginController { 
	@Autowired
	public UserService userService;
	//@postMapping is used to handle the post req to /login , in this method
	@PostMapping("/login") 
	public Response<?> login(@RequestBody Credential cr, HttpSession httpSession) {
		//first it fetches credential from body , if the credential is correct valid then stores the user inf in session, 
		//then return successful response  // then set status sucessful correct then its successful if incorrect then its failed error
   	 // service layer: authentication and store in session
   	 User user = userService.authenticate(cr); 
   	 if(user != null) {
   		 httpSession.setAttribute("curUser", user);
   		return Response.success("success");
   	 }
   	  return Response.error("Login failed");
	 
//   	@PostMapping("/api/login")
//    public ResponseEntity<String> authenticateUser(@RequestBody Credentials cr, HttpSession session) {
//        User user = userService.authenticate(cr);
//        if (user != null) {
//            session.setAttribute("curUser", user);
//            return ResponseEntity.ok("Login successful");
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//    }
    }
	@PostMapping("/logout")
	public Response<?> signout(HttpSession session){
		session.invalidate();
		return Response.success("success");
	}
	 
	@GetMapping("/test") 
	public Response<?> test(HttpSession session){
		User u = (User)session.getAttribute("curUser"); //cast kb krte user u object set kiya or get ke time session.getattribute Obj class ka o obj return krta
		//set krte time 
		return Response.success(u); //ye kyo kiya tha  idhr login nai or logout likha nai link kaisi lagi 3 mapping ki
	}
//	@PostMapping("/api/logout")
//    public ResponseEntity<String> signout(HttpSession session) {
//        session.invalidate();
//        return ResponseEntity.ok("Logout successful");
//    }
	
 
}
