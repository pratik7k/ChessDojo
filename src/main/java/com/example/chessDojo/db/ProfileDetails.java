package com.example.chessDojo.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class ProfileDetails {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String profilePhotoUrl;

    @OneToOne(cascade = CascadeType.ALL)
    private Ratings ratings;

    // Getters and Setters
}
