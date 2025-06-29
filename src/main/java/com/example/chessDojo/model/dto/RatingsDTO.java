package com.example.chessDojo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingsDTO {
    public int bullet, blitz, rapid, classical, correspondence, puzzle;
}
