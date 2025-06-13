package com.example.demo.controller;

import com.example.demo.dto.request.UserRegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @PostMapping(value = "/registerUser", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        try {
            log.info("User registration endpoint hit");
            return "User registered successfully";
        } catch (Exception e) {
            log.error("Error during user registration", e);
            throw new RuntimeException("User registration failed");
        }
    }
}
