package com.example.chessDojo.model.db;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
public class Game {

    @Id
    private String gameId;

    private String whitePlayerId;
    private String blackPlayerId;

    @ElementCollection
    private List<String> uciMoves = new ArrayList<>(); // move list in UCI format

    private String result;  // "1-0", "0-1", "½-½"
    private String currentFen;
    private int turn;

    // Castling rights
    private boolean whiteCanCastleKingSide;
    private boolean whiteCanCastleQueenSide;
    private boolean blackCanCastleKingSide;
    private boolean blackCanCastleQueenSide;

    // Clocks (in milliseconds)
    private long whiteTimeLeft;  // e.g., 300000 for 5 minutes
    private long blackTimeLeft;

    // Draw offer statuses
    private boolean drawOfferedByWhite;
    private boolean drawOfferedByBlack;

    // Resign flags
    private boolean whiteResigned;
    private boolean blackResigned;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime endedAt;

    public boolean isDrawOffered() {
        return drawOfferedByWhite || drawOfferedByBlack;
    }

    public void clearDrawOffers() {
        drawOfferedByWhite = false;
        drawOfferedByBlack = false;
    }

}
