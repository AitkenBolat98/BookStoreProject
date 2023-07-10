package com.example.BookStoreProject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private final JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String receiver, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(receiver);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("kaispringboot@gmail.com");
        javaMailSender.send(mailMessage);
    }
}
