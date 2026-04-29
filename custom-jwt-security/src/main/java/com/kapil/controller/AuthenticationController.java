package com.kapil.controller;

import com.kapil.dto.AuthenticationRequest;
import com.kapil.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest request)  {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        List<String> roles = user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        String token = jwtUtil.generateToken(user.getUsername(), roles);
        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);
        resp.put("type", "Bearer");
        return ResponseEntity.ok(resp);
    }
    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint() {
        Map<String, String> resp = new HashMap<>();
        resp.put("message", "CUSTOM-JWT-SECURITY service is running");
        return ResponseEntity.ok(resp);
    }
}