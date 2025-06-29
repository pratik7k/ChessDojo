package com.example.chessDojo.repo;


import com.example.chessDojo.db.AuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AuthRepository extends JpaRepository<AuthDetails, UUID> {}
