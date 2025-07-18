package com.example.chessDojo.repo;

import com.example.chessDojo.model.db.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findByUsername(String username);
    Optional<Player> findByEmail(String email);

}