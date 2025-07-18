package com.example.chessDojo.controller;

import com.example.chessDojo.model.dto.*;
import com.example.chessDojo.security.JwtUtil;
import com.example.chessDojo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SignupService signupService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody CreatePlayerDTO request) {
        try {
            JwtResponse response = signupService.signup(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        System.out.println(">>> LOGIN CALLED for username = " + request.getUsername());

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(request.getUsername());
        System.out.println("Generated Token: " + token);
        return new JwtResponse(token);
    }
}
