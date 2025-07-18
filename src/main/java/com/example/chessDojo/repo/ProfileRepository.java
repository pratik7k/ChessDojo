package com.example.chessDojo.repo;

import com.example.chessDojo.model.db.ProfileDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileDetails, String> {}
