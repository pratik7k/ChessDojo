package com.example.chessDojo.repo;

import com.example.chessDojo.db.ProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileDetails, UUID> {}
