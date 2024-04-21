package com.rest;

import com.rest.entity.User;
import com.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BaseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        String domain = "shbfinance.com.vn";
        List<User> users = new ArrayList<>();
        String[] arr = new String[]{
                "binh.tt20",
                "dat.nt31",
                "binh.tl",
                "phuong.td3",
                "tinh.tq1",
                "phat.lt5",
                "huyen.nt49"
        };
        for (String username : arr) {
            User user = new User();
            user.setFullname("Nguyen Van " + username);
            user.setUsername(username);
            user.setEmail(username + "@" + domain);
            user.setDomain(domain);
            users.add(user);
        }
        userRepository.saveAll(users);
    }
}
