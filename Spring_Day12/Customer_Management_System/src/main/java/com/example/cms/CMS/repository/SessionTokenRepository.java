package com.example.cms.CMS.repository;

import com.example.cms.CMS.entity.SessionToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionTokenRepository extends JpaRepository<SessionToken,Long> {
    Optional<SessionToken> findByToken(String token);
}
