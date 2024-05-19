package com.titip.dto;

import lombok.Data;

@Data
public class ReturnRequest {
    private Long lockerId;
    private String password;

    // Getters and setters
}
