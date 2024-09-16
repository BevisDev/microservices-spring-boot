package com.bevis.notification.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail() {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("trthanhbinh5720@gmail.com");
            String[] toEmails = new String[] {"dev.binhtt@gmail.com", "kimbapham96@gmail.com"};

            helper.setTo(toEmails);
            helper.setSubject("[SUBJECT] EMAIL");
            helper.setText("TESTST CONTENT", true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
