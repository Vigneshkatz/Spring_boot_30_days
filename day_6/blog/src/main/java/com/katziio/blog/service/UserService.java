package com.katziio.blog.service;


import com.katziio.blog.dto.PostDetailedDTO;
import com.katziio.blog.dto.UserDTO;
import com.katziio.blog.entity.Post;
import com.katziio.blog.entity.User;
import com.katziio.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserDTO addUser(User user) {
        this.userRepository.save(user);
        return new UserDTO(user);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if(optionalUser.isPresent())
        {
            return new UserDTO(optionalUser.get());
        }
        return null;
    }

    public UserDTO deleteUserById(Long userId) {
        UserDTO user = this.getUserById(userId);
        if(user!=null)
        {
            this.userRepository.deleteById(userId);
            return user;
        }
        else{
            return null;
        }
    }

    public UserDTO updateUserById(Long userId, User user) {
        Optional<User> optionalPost = this.userRepository.findById(userId);
        if (optionalPost.isPresent()) {
            User dbUser = optionalPost.get();
            dbUser.setName(user.getName());
            dbUser.setEmail(user.getEmail());
            dbUser.setPassword(user.getPassword());
            this.userRepository.save(dbUser);
            return new UserDTO(dbUser);
        }
        return null;
    }

    public UserDTO getUserByEmailPassword(String email, String password) {
        User user = this.userRepository.findUserByEmailPassword(email, password);
        if (user!=null) {
            return new UserDTO(user);
        } else {
            return null;
        }
    }
}
