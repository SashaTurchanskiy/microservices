package com.zosh.service.impl;

import com.zosh.enums.UserRole;
import com.zosh.model.User;
import com.zosh.payload.dto.UserDTO;
import com.zosh.payload.response.AuthResponse;
import com.zosh.repository.UserRepository;
import com.zosh.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(String email, String password) {
        return null;
    }

    @Override
    public AuthResponse signup(UserDTO req) throws Exception {
        User existingUser = userRepository.findByEmail(req.getEmail()).orElse(null);
        if (existingUser != null) {
            throw new Exception("email already registered");
        }
        if (req.getRole() == UserRole.ROLE_SYSTEM_ADMIN){
            throw new Exception("you cannot sign up system admins!");
        }
        User newUser = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .role(req.getRole())
                .lastLoginAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(newUser);

        return null;
    }
}
