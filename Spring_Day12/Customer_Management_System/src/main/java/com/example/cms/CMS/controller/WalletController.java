package com.example.cms.CMS.controller;

import com.example.cms.CMS.entity.Wallet;
import com.example.cms.CMS.repository.UserRepository;
import com.example.cms.CMS.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Wallet> addMoney(@RequestParam Long id,@RequestParam double amount){
        Wallet wallet=walletRepository.findByUserId(id);
        wallet.setBalance(wallet.getBalance()+amount);
        walletRepository.save(wallet);
        return ResponseEntity.ok(wallet);
    }

}
