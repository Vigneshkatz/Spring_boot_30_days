package com.katziio.emailverify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    public void initiateEmail(String confirmationToken,String toEmail)
    {
        System.out.println(5);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("sanvignesh7890@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8000/v1/confirm-account/"+confirmationToken);
        System.out.println(6);
       this.sendEmail(mailMessage);
    }
}