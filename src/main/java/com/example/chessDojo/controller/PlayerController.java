package com.example.chessDojo.controller;

import com.example.chessDojo.model.dto.CreatePlayerDTO;
import com.example.chessDojo.model.dto.PlayerDTO;
import com.example.chessDojo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody CreatePlayerDTO dto) {
        return ResponseEntity.ok(playerService.createPlayer(dto));
    }

    @GetMapping("/{username}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable String username) {
        return playerService.getPlayerByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
