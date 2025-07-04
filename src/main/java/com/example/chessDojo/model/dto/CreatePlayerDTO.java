package com.example.chessDojo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerDTO {
    private String username;
    private String email;
}