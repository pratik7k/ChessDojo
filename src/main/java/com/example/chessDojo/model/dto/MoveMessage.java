package com.example.chessDojo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MoveMessage {
    private String type = "move"; // can be 'move', 'resign', 'draw_offer', etc.
    private String gameId;

    // Move details
    private String uci;      // e.g., e2e4
    private String san;      // e.g., e4
    private String fen;      // optional
    private String lastMove; // e.g., e7e5
    private String wc;       // e.g., a1h1 //can castle
    private String bc;       // e.g., a8h8 //can castle
    private int turn;        // move number
    private String playerId;

    // Optional: time left, result, flags


}
