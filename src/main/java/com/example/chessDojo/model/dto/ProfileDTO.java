package com.example.chessDojo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProfileDTO {
    public UUID id;
    public String username;
    public String profilePhotoUrl;
    public RatingsDTO ratings;
}