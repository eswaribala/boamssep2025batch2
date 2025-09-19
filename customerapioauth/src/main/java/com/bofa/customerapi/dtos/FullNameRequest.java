package com.bofa.customerapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FullNameRequest {

    @NotNull
    //add first name validation
    @Pattern(regexp = "^[A-Za-z]{3,50}$", message = "First name must contain only letters")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    private String middleName;
    @NotNull
    @Pattern(regexp = "^[A-Za-z]{3,50}$", message = "Last name must contain only letters")
    @NotBlank(message = "First name cannot be blank")
    private String lastName;

}
