package com.example.chessDojo.model.dto;



import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthDTO {
    public String id;
    public String password;
    public String googleAuthId;


}
