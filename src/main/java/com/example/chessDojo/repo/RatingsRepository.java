package com.example.chessDojo.repo;

import com.example.chessDojo.model.db.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingsRepository extends MongoRepository<Ratings, String> {}