package com.example.chessDojo.db;


import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private AuthDetails auth;

    @OneToOne(cascade = CascadeType.ALL)
    private ProfileDetails profile;


}

