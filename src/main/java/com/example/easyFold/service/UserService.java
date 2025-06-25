package com.example.easyFold.service;

import com.example.easyFold.dto.request.UserRegistrationRequest;
import com.example.easyFold.dto.response.ResponseModel;
import com.example.easyFold.entity.Users;
import com.example.easyFold.repository.UsersRepository;
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
    private final UsersRepository userRepository;
    public ResponseModel registerUser(@Valid UserRegistrationRequest userRegistrationRequest) {
        try {
            if(userRegistrationRequest == null){
                throw new RuntimeException("Request data is null");
            }
            Users user = new Users();
            user.setUserType(userRegistrationRequest.getUserType());
            user.setFirstName(userRegistrationRequest.getFirstName());
            user.setMiddleName(userRegistrationRequest.getMiddleName() != null ? userRegistrationRequest.getMiddleName() : "");
            user.setLastName(userRegistrationRequest.getLastName());
            user.setDob(userRegistrationRequest.getDob());
            user.setGender(userRegistrationRequest.getGender());
            user.setMfaEnabled(false);
            user.setEmail(userRegistrationRequest.getEmail());

            Users savedUser = userRepository.save(user);

        } catch (Exception e) {
            return ResponseModel.builder()
                    .status(ResponseModel.ResponseStatusTypeEnum.SUCCESS)
                    .message("User Registration unsuccessful")
                    .build();
        }
    }
}
