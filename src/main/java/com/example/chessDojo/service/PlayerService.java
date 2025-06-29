package com.example.chessDojo.service;

import com.example.chessDojo.model.dto.*;
import com.example.chessDojo.db.Player;
import com.example.chessDojo.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerDTO createPlayer(CreatePlayerDTO dto) {
        Player player = Player.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
        Player saved = playerRepository.save(player);
        return mapToDto(saved);
    }

    public Optional<PlayerDTO> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username).map(PlayerService::mapToDto);
    }

    public static PlayerDTO mapToDto(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .username(player.getProfile().getUsername())
                .email(player.getEmail())
                .auth(AuthDTO.builder()
                        .id(player.getAuth().getId())
                        .googleAuthId(player.getAuth().getGoogleAuthId())
                        .password(null) // Do not expose password hash
                        .build())
                .profile(ProfileDTO.builder()
                        .id(player.getProfile().getId())
                        .username(player.getProfile().getUsername())
                        .profilePhotoUrl(player.getProfile().getProfilePhotoUrl())
                        .ratings(RatingsDTO.builder()
                                .bullet(player.getProfile().getRatings().getBullet())
                                .blitz(player.getProfile().getRatings().getBlitz())
                                .rapid(player.getProfile().getRatings().getRapid())
                                .classical(player.getProfile().getRatings().getClassical())
                                .correspondence(player.getProfile().getRatings().getCorrespondence())
                                .puzzle(player.getProfile().getRatings().getPuzzle())
                                .build())
                        .build())
                .build();
    }
}

