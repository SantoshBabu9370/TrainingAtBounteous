package com.example.cms.CMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionToken {
    @Id
    @GeneratedValue
    private Long id;
    private String token;
    private Date expiryDate;

    @ManyToOne
    private User user;
}
