package com.example.chessDojo.service;

import com.example.chessDojo.model.dto.CreatePlayerDTO;
import com.example.chessDojo.model.dto.JwtResponse;
import com.example.chessDojo.repo.PlayerRepository;
import com.example.chessDojo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private JwtUtil jwtUtil;

    public JwtResponse signup(CreatePlayerDTO dto) {
        if (playerRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        if (playerRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        playerService.createPlayer(dto);
        String token = jwtUtil.generateToken(dto.getUsername());
        return new JwtResponse(token);
    }
}
