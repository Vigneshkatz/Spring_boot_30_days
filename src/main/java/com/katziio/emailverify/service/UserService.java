package com.katziio.emailverify.service;

import com.katziio.emailverify.entity.User;
import com.katziio.emailverify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return this.userRepository.save(user);
    }

    public User verifyUser(String token)
    {
        User user= this.userRepository.findByToken(token);
        if(user!=null)
        {
            user.setActive(true);
            this.userRepository.save(user);
            return user;
        }
        return null;
    }
}
