package com.example.chessDojo.model.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    private String id = UUID.randomUUID().toString();  // Store UUID as String

    private String username;
    private String email;

    private String authId;     // Reference to AuthDetails._id
    private String profileId;  // Reference to ProfileDetails._id


}
