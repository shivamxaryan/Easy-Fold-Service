package com.example.easyFold.dto.request;

import com.example.easyFold.entity.Enum.GenderType;
import com.example.easyFold.entity.Enum.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UserRegistrationRequest {
    @NotBlank(message = "TemplateMessages.EMPTY_FIRST_NAME")
    @Size(max = 100, message = "TemplateMessages.EXCEED_FIRST_NAME_LENGTH")
    private String firstName;

    @Size(max = 100, message = "TemplateMessages.EXCEED_MIDDLE_NAME_LENGTH")
    private String middleName;

    @NotBlank(message = "TemplateMessages.EMPTY_LAST_NAME")
    @Size(max = 100, message = "TemplateMessages.EXCEED_LAST_NAME_LENGTH")
    private String lastName;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    @NotBlank(message = "Please enter a valid date of birth")
    private String dob;

    @NotNull(message = "Gender cannot be blank")
    private GenderType gender;

    @Email
    private String email;

    private PhoneRequestDto phoneNumberInfo;

    private AddressRequestDto address;

    @NotNull(message = "User type cannot be blank")
    private UserType userType;

}
