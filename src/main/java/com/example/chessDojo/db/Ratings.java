package com.example.chessDojo.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Ratings {
    @Id
    @GeneratedValue
    private UUID id;

    private int bullet;
    private int blitz;
    private int rapid;
    private int classical;
    private int correspondence;
    private int puzzle;

    // Getters and Setters
}
