package com.katziio.emailverify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import javax.validation.constraints.*;
import java.security.SecureRandom;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty
    private String username;
    @Email
    private String email;
    @Size(min = 8)
    private String password;

    private boolean isActive;
    private String token;

}
