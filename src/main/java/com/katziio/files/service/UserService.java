package com.katziio.files.service;


import com.katziio.files.entity.User;
import com.katziio.files.helper.CSVHelper;
import com.katziio.files.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.PrintWriter;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> readFile(MultipartFile file) {
        if(!CSVHelper.hasCSVFormat(file))
        {
            System.out.println("not the expected file");
            return null;
        }
        try {
            List<User> userList = CSVHelper.csvToUser(file.getInputStream());
            userRepository.saveAll(userList);
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void writeEmployeesToCsv(PrintWriter writer) {
        CSVHelper.writeEmployeesToCsv(writer,userRepository.findAll());
    }
}
