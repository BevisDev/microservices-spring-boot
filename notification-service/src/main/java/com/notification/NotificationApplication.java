package com.notification;

import com.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Autowired
    private EmailService emailService;

    @Override
    public void run(String... args) throws Exception {
        emailService.sendMail();

    }
}
