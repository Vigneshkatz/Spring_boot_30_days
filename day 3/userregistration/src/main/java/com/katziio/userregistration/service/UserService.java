package com.katziio.userregistration.service;

import com.katziio.userregistration.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    public String addUser(UserDTO userDTO);

}
