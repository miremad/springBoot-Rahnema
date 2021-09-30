package com.example.demo.controller;


import com.example.demo.configuration.JwtTokenUtil;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    @Data
    public static class AuthRequest {

        private String username;
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthResponse {

        private String token;
    }

    final AuthenticationManager authenticationManager;
    final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        Authentication athentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = (User) athentication.getPrincipal();
        AuthResponse res = new AuthResponse(jwtTokenUtil.generateToken(user));
        return res;
    }
}
