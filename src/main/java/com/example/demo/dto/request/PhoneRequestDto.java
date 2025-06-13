package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class PhoneRequestDto {
    private UUID userId;

    @NotBlank(message = "Please enter the valid Mobile")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number format")
    private String phoneNumber;

    @JsonProperty("isPrimary")
    private boolean isPrimary;
}
