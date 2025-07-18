package com.example.chessDojo.model.dto;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}
