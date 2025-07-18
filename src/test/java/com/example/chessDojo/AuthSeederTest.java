package com.example.chessDojo;

import com.example.chessDojo.model.db.AuthDetails;
import com.example.chessDojo.repo.AuthDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class AuthSeederTest {

    @Autowired
    private AuthDetailsRepository repo;

    @Test
    void createAdminUser() {
        if (repo.findByUsername("admin").isEmpty()) {
            AuthDetails user = new AuthDetails();
            user.setUsername("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            repo.save(user);
            System.out.println("✅ Admin user seeded.");
        } else {
            System.out.println("ℹ️ Admin already exists.");
        }
    }
}
