package com.example.chessDojo.repo;

import com.example.chessDojo.model.db.ProfileDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileDetailsRepository extends MongoRepository<ProfileDetails, String> {
    Optional<ProfileDetails> findByUsername(String username);

}