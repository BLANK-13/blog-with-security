package com.example.blogwithsecurity.Controllers;

import com.example.blogwithsecurity.Models.User;
import com.example.blogwithsecurity.Services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {


    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid User user) {
        authService.register(user);
        return ResponseEntity.ok("User registered ");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){

        return ResponseEntity.ok("User registered ");

    }
}