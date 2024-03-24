package com.camunda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class HealthCheckController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/health-check")
    public ResponseEntity<?> getStatus() {
        Map<String, String> map = new HashMap<>();
        map.put("service", "system");
        map.put("status", "Ok");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/health-check-database")
    public ResponseEntity<?> getStatusDatabase() {
        Map<String, String> map = new HashMap<>();
        map.put("service", "database");
        try {
            Query query = entityManager.createQuery("SELECT 1");
            if (null != query.getSingleResult()) {
                map.put("status", "Ok");
            }
        } catch (Exception ex) {
            log.error("has error: ", ex);
            map.put("message", ex.getMessage());
        }
        return ResponseEntity.ok(map);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add-user")
    public ResponseEntity<?> addUser() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        try {
            User user2 = userRepository.save(user);
            return ResponseEntity.ok(user2);
        } catch (Exception ex) {
            log.error("has error: ", ex);
            user.setUsername(ex.getMessage());
        }
        return ResponseEntity.ok(user);
    }

}
