package com.example.demo.controller;

import com.example.demo.dto.request.UserRegistrationRequest;
import com.example.demo.dto.response.ResponseModel;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/registerUser", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseModel> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        try {
            ResponseModel response = userService.registerUser(userRegistrationRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error during user registration", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseModel(ResponseModel.ResponseStatusTypeEnum.FAILURE, "Error registering user: " + e.getMessage(), null));
        }
    }
}
