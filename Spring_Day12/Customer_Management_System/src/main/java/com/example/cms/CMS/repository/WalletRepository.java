package com.example.cms.CMS.repository;

import com.example.cms.CMS.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Wallet findByUserId(Long id);
}
