package com.example.chessDojo.repo;


import com.example.chessDojo.model.db.AuthDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthDetailsRepository extends MongoRepository<AuthDetails, String> {
    Optional<AuthDetails> findByGoogleAuthId(String googleAuthId);
    Optional<AuthDetails> findByUsername(String username);

}
