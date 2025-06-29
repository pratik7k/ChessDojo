package com.example.chessDojo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PlayerDTO {
    private UUID id;
    private String username;
    private String email;
    public AuthDTO auth;
    public ProfileDTO profile;
}
