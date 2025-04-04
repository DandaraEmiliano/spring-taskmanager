package com.dandara.taskmanager.service;

import com.dandara.taskmanager.dto.AuthRequest;
import com.dandara.taskmanager.entity.User;
import com.dandara.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(AuthRequest request) {
        boolean exists = userRepository.findByUsername(request.getUsername()).isPresent();
        if (exists) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }
}
