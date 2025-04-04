package com.dandara.taskmanager.controller;

import com.dandara.taskmanager.dto.AuthRequest;
import com.dandara.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        userService.register(request);
        return "User registered successfully";
    }

}
