package com.example.demo.service;

import com.example.demo.entity.UserDetails;
import com.example.demo.repo.RepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass {
    @Autowired
    RepositoryClass repo;

    public List<UserDetails> findall() {
        List<UserDetails> list = repo.findAll();
        return list;
    }

    public void addUser(UserDetails userDetail) {
        repo.save(userDetail);
    }

    public int deleteUser(Long id) {
        Optional<UserDetails> userDetails = repo.findById(id);
        if (userDetails == null) {
            return 0;

        } else {
            repo.deleteById(id);
            return 1;
        }

    }

    public boolean updateUser(Long id, UserDetails updatedUserDetails) {
        Optional<UserDetails> existingUserOptional = repo.findById(id);
        if (existingUserOptional.isPresent()) {
            UserDetails existingUser = existingUserOptional.get();
            existingUser.setName(updatedUserDetails.getName());
            existingUser.setAge(updatedUserDetails.getAge());
            repo.save(existingUser);
            return true;
        } else {
            return false;
        }
    }
}

