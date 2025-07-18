package com.example.chessDojo.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "authdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthDetails {

    @Id
    @GeneratedValue
    private String id = UUID.randomUUID().toString();

    private String username;       // <--- use this in login
    private String password;       // stored as BCrypt hash
    private String googleAuthId;   // Used as username


}

