package com.katziio.userregistration.service.impl;

import com.katziio.userregistration.dto.UserDTO;
import com.katziio.userregistration.entity.User;
import com.katziio.userregistration.repository.UserRepository;
import com.katziio.userregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepository.save(user);

        return  user.getEmail();
    }
}
