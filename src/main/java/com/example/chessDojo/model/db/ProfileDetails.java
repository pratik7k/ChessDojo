package com.example.chessDojo.model.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "profiledetails")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDetails {

    @Id
    private String id = UUID.randomUUID().toString();

    private String username;
    private String profilePhotoUrl;

    // Instead of @OneToOne, use manual referencing
    private String ratingsId;
}
