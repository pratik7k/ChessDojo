package com.example.chessDojo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerDTO {
    private String username;
    private String email;
    private String password;       // Plain password (will be encoded)
    private String googleAuthId;   // Optional, if using Google Auth
    private String profilePhotoUrl;
}
