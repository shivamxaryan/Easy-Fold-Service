package com.example.demo.service;

import com.example.demo.dto.request.UserRegistrationRequest;
import com.example.demo.dto.response.ResponseModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    public ResponseModel registerUser(@Valid UserRegistrationRequest userRegistrationRequest) {
        try {
            return null;
        } catch (Exception e) {
            return ResponseModel.builder()
                    .status(ResponseModel.ResponseStatusTypeEnum.SUCCESS)
                    .message("User Registration unsuccessful")
                    .build();
        }
    }
}
