package com.bofa.customerapi.dtos;

public record IndividualResponse(String accountNo, FullNameResponse fullNameResponse, String email, String contactNo) {
}
