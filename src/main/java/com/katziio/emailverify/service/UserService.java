package com.katziio.emailverify.service;

import com.katziio.emailverify.entity.ConfirmationToken;
import com.katziio.emailverify.entity.User;
import com.katziio.emailverify.repository.ConfirmationTokenRepository;
import com.katziio.emailverify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public User saveUser(User user) {
        System.out.println(1);
        User u = this.userRepository.findByEmail(user.getEmail());
        if (u == null) {
            System.out.println(2);
            userRepository.save(user);
            System.out.println(3);
            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);
            System.out.println(4);
            this.emailSenderService.initiateEmail(confirmationToken.getConfirmationToken(),user.getEmail());
            System.out.println(7);
            System.out.println("successfulRegistration");
            return this.userRepository.save(user);
        }
        return null;
    }

    public User verifyAccount(String confirmationToken) {
        ConfirmationToken dbToken = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (dbToken != null) {
            User user = userRepository.findByEmail(dbToken.getUser().getEmail());
            user.setActive(true);
            userRepository.save(user);
            System.out.println("heibfdsvbisuhv");
            return user;
        } else {
            return null;
        }

    }
}
