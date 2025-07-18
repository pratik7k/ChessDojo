package com.example.chessDojo.model.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ratings {

    @Id
    private String id = UUID.randomUUID().toString();  // generate UUID as String

    private int bullet;
    private int blitz;
    private int rapid;
    private int classical;
    private int correspondence;
    private int puzzle;
    private int practiceRatting;
    private int preformanceRatting;
}
