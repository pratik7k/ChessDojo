package com.example.chessDojo.security;

import com.example.chessDojo.model.db.AuthDetails;
import com.example.chessDojo.repo.AuthDetailsRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final AuthDetailsRepository authDetailsRepository;

    public MyUserDetailsService(AuthDetailsRepository authDetailsRepository) {
        this.authDetailsRepository = authDetailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthDetails auth = authDetailsRepository.findByUsername(username)  //  use username field
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(auth.getUsername()) //  use correct field
                .password(auth.getPassword()) // assumed to be BCrypt encoded
                .roles("USER")
                .build();
    }
}
