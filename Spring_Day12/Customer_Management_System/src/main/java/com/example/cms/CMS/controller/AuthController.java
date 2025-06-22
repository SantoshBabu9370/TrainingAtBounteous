package com.example.cms.CMS.controller;

import com.example.cms.CMS.entity.User;
import com.example.cms.CMS.repository.UserRepository;
import com.example.cms.CMS.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password){
        User user=userRepository.findByUsername(username).orElseThrow(
                () ->   new RuntimeException("User Not Found")
        );
        if (new BCryptPasswordEncoder().matches(password,user.getPassword())){
            String token=tokenService.generateToken(user);
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
