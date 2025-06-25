package com.example.easyFold.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhoneRequestDto {
    private UUID userId;

    @NotBlank(message = "Please enter the valid Mobile")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number format")
    private String phoneNumber;

    @JsonProperty("isPrimary")
    private boolean isPrimary;
}
