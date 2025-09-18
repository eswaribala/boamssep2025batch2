package com.bofa.customerapi.dtos;

import com.bofa.customerapi.models.Gender;

import java.time.LocalDate;

public record IndividualResponse(String accountNo, FullNameResponse fullNameResponse, String email, String contactNo) {
}
