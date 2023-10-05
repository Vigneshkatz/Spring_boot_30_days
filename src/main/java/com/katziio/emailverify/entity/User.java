package com.katziio.emailverify.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String username;

    @Email
    @Column(unique = true)
    @NotEmpty
    private String email;
//    @Pattern(regexp = "^(?=.*?[A-Z])(?:(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\]{},.<>+=])|(?=.*?[a-z])(?:(?=.*?[0-9])|(?=.*?[-!@#$%^&*()_[\\]{},.<>+=]))|(?=.*?[a-z])(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\]{},.<>+=]))[A-Za-z0-9!@#$%^&*()_[\\]{},.<>+=-]{7,50}$")
    private String password;

    private boolean isActive;

}
