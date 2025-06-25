package com.example.easyFold.service;

import com.example.easyFold.dto.request.UserRegistrationRequest;
import com.example.easyFold.dto.response.ResponseModel;
import com.example.easyFold.entity.Address;
import com.example.easyFold.entity.UserPhones;
import com.example.easyFold.entity.Users;
import com.example.easyFold.repository.AddressRepository;
import com.example.easyFold.repository.PhoneRepository;
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
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;

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
            user.setPasswordHash(userRegistrationRequest.getPassword());
            Users savedUser = userRepository.save(user);

            UserPhones phone = new UserPhones();
            phone.setUser(savedUser);
            phone.setNumber(userRegistrationRequest.getPhoneNumberInfo().getPhoneNumber());
            phone.setPrimary(true);
            phoneRepository.save(phone);

            Address address = new Address();
            address.setAddressType(userRegistrationRequest.getAddress().getAddressType());
            address.setAddressLine1(userRegistrationRequest.getAddress().getAddressLine1());
            address.setAddressLine2(userRegistrationRequest.getAddress().getAddressLine2());
            address.setState(userRegistrationRequest.getAddress().getState());
            address.setDistrict(userRegistrationRequest.getAddress().getDistrict());
            address.setTehsil(userRegistrationRequest.getAddress().getTehsil());
            address.setCity(userRegistrationRequest.getAddress().getCity());
            address.setPincode(userRegistrationRequest.getAddress().getPincode());
            addressRepository.save(address);

            return ResponseModel.builder()
                    .status(ResponseModel.ResponseStatusTypeEnum.SUCCESS)
                    .message("User Registered Successfully.")
                    .build();

        } catch (Exception e) {
            return ResponseModel.builder()
                    .status(ResponseModel.ResponseStatusTypeEnum.SUCCESS)
                    .message("User Registration unsuccessful")
                    .build();
        }
    }
}
