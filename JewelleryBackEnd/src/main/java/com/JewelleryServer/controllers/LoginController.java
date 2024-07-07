package com.JewelleryServer.controllers;

import com.JewelleryServer.pojo.Credential;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.services.UserService;
import com.JewelleryServer.session.SessionManager;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
    originPatterns = { "https://localhost", "http://localhost:3000", "*" },
    allowCredentials = "true",
    allowedHeaders = "*"
)
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
        @RequestBody Credential cr,
        HttpSession session
    ) {
        User user = userService.authenticate(cr);
        if (user != null) {
            // Store session in SessionManager instead of HttpSession
            SessionManager.storeSession(session.getId(), user);
            // Set the session ID as a response header (if necessary)
            return ResponseEntity.ok()
                .body(
                    "{\"status\":\"success\",\"role\":\"" +
                    user.getRole() +
                    "\" , \"sessionId\":\"" +
                    session.getId() +
                    "\" }"
                );
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            "Login Failed"
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // Remove session from SessionManager
        SessionManager.removeSession(session.getId());
        session.invalidate();
        return ResponseEntity.ok("Logout success");
    }
}
