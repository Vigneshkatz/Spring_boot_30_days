package com.katziio.files.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String place;
    private Long pincode;
    private String area;
    private String landmark;
    private String city;
    private String state;
    private Long phoneNumber;

    public User(long userId, String name, String email, String password, String place,
                long pincode, String area, String landmark, String city, String state, long phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.place = place;
        this.pincode = pincode;
        this.area = area;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;

    }
}
