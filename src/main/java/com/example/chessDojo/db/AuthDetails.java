package com.example.chessDojo.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class AuthDetails {
    @Id
    @GeneratedValue
    private UUID id;

    private String passwordHash;
    private String googleAuthId;

    // Getters and Setters
}
