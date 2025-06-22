package com.example.cms.CMS.service;

import com.example.cms.CMS.entity.SessionToken;
import com.example.cms.CMS.entity.User;
import com.example.cms.CMS.repository.SessionTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    public String generateToken(User user){
        String token= UUID.randomUUID().toString();
        SessionToken sessionToken=new SessionToken();
        sessionToken.setToken(token);
        sessionToken.setUser(user);
        sessionToken.setExpiryDate(new Date(System.currentTimeMillis()+86400000));
        sessionTokenRepository.save(sessionToken);
        return token;

    }

    public boolean isValid(String token){
        return sessionTokenRepository.findByToken(token).map(t->t.getExpiryDate().after(new Date())).orElse(false);
    }
}
