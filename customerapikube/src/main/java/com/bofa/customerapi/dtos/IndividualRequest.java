package com.bofa.customerapi.dtos;

import com.bofa.customerapi.models.FullName;
import com.bofa.customerapi.models.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.websocket.OnOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualRequest {




    private FullName fullName;


    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private  String email;



    @NotNull(message = "Contact number cannot be null")
    @NotBlank(message = "Contact number cannot be blank")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Contact number must be valid")
    private  String contactNo;



    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long and include at least one uppercase letter, " +
                    "one lowercase letter, one digit, and one special character")
    private  String password;

    private Gender gender;


    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in the format YYYY-MM-DD")
    private LocalDate birthDate;

}
