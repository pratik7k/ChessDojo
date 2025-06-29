package com.example.chessDojo.repo;

import com.example.chessDojo.db.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingsRepository extends JpaRepository<Ratings, UUID> {}