package com.example.charting.gateway.controller;

import com.example.charting.gateway.configuration.JwtTokenUtil;
import com.example.charting.gateway.model.AppUser;
import com.example.charting.gateway.model.LoginRequest;
import com.example.charting.gateway.model.LoginResponse;
import com.example.charting.gateway.service.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AppUserDetailService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup/user")
    public void signUp(@RequestBody AppUser user) {
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userService.signUp(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/signup/admin")
    public void signUpAdmin(@RequestBody AppUser user) {
        user.setRole("ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userService.signUp(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {

        authenticate(loginRequest.getUsername(),loginRequest.getPassword());

        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
