package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.auth.api.AuthApi;
import com.clickhealth.pharma.auth.model.LoginRequest;
import com.clickhealth.pharma.auth.model.LoginResponse;
import com.clickhealth.pharma.security.JwtTokenProvider;
import com.clickhealth.pharma.user.model.User;
import com.clickhealth.pharma.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class AuthController implements AuthApi {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        // Validate user credentials (this is a custom method in your UserService)
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getRole().name());

        // Build and return response
        LoginResponse response = new LoginResponse()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn((int)jwtTokenProvider.getExpiration());

        return ResponseEntity.ok(response);
    }
}
