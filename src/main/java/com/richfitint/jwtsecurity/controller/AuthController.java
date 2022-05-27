package com.richfitint.jwtsecurity.controller;

import com.richfitint.jwtsecurity.entity.user.User;
import com.richfitint.jwtsecurity.model.UserAuthRequest;
import com.richfitint.jwtsecurity.service.user.UserService;
import com.richfitint.jwtsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public String getToken(@RequestBody UserAuthRequest user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Auth failed");
        }
        return "Bearer " + jwtUtil.generateToken(user.getLogin());
    }

    @PostMapping("/sign-up")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
