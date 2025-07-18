package com.example.chessDojo.service;

import com.example.chessDojo.model.db.*;
import com.example.chessDojo.model.dto.*;
import com.example.chessDojo.repo.AuthDetailsRepository;
import com.example.chessDojo.repo.PlayerRepository;
import com.example.chessDojo.repo.ProfileDetailsRepository;
import com.example.chessDojo.repo.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private ProfileDetailsRepository profileDetailsRepository;

    @Autowired
    private AuthDetailsRepository authDetailsRepository;

    public PlayerDTO createPlayer(CreatePlayerDTO dto) {

        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        // Create Ratings
        Ratings ratings = Ratings.builder()
                .id(UUID.randomUUID().toString())
                .bullet(1000)
                .blitz(1000)
                .rapid(1000)
                .classical(1000)
                .correspondence(1000)
                .puzzle(0)
                .practiceRatting(1000)
                .preformanceRatting(1000)
                .build();

        ratingsRepository.save(ratings);

        // 2. Create and save ProfileDetails with reference to ratingsId
        ProfileDetails profile = ProfileDetails.builder()
                .id(UUID.randomUUID().toString())
                .username(dto.getUsername())
                .profilePhotoUrl(dto.getProfilePhotoUrl())
                .ratingsId(ratings.getId())
                .build();

        profileDetailsRepository.save(profile);

        // 3. Create and save AuthDetails
        AuthDetails auth = AuthDetails.builder()
                .id(UUID.randomUUID().toString())
                .username(dto.getUsername())
                .password(encodedPassword) // Should be encoded before this
                .googleAuthId(dto.getGoogleAuthId())
                .build();

        authDetailsRepository.save(auth);

        // 4. Create and save Player with references
        Player player = Player.builder()
                .id(UUID.randomUUID().toString())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .authId(auth.getId())
                .profileId(profile.getId())
                .build();

        Player saved = playerRepository.save(player);
        return mapToDto(saved);
    }

    public Optional<PlayerDTO> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username).map(this::mapToDto);
    }

    public PlayerDTO mapToDto(Player player) {
        // Fetch AuthDetails
        AuthDetails auth = null;
        if (player.getAuthId() != null) {
            auth = authDetailsRepository.findById(player.getAuthId()).orElse(null);
        }

        // Fetch ProfileDetails
        ProfileDetails profile = null;
        Ratings ratings = null;
        if (player.getProfileId() != null) {
            profile = profileDetailsRepository.findById(player.getProfileId()).orElse(null);

            if (profile != null && profile.getRatingsId() != null) {
                ratings = ratingsRepository.findById(profile.getRatingsId()).orElse(null);
            }
        }

        return PlayerDTO.builder()
                .id(player.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .auth(auth != null ? AuthDTO.builder()
                        .id(auth.getId())
                        .googleAuthId(auth.getGoogleAuthId())
                        .password(null) // Hide password
                        .build() : null)
                .profile(profile != null ? ProfileDTO.builder()
                        .id(profile.getId())
                        .username(profile.getUsername())
                        .profilePhotoUrl(profile.getProfilePhotoUrl())
                        .ratings(ratings != null ? RatingsDTO.builder()
                                .bullet(ratings.getBullet())
                                .blitz(ratings.getBlitz())
                                .rapid(ratings.getRapid())
                                .classical(ratings.getClassical())
                                .correspondence(ratings.getCorrespondence())
                                .puzzle(ratings.getPuzzle())
                                .preformanceRatting(ratings.getPreformanceRatting())
                                .practiceRatting(ratings.getPracticeRatting())
                                .build() : null)
                        .build() : null)
                .build();
    }
}


