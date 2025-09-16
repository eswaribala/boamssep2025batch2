package com.bofa.customerapi.dtos;

public record IndividualResponse(long accountNo, FullNameResponse fullNameResponse, String email, String contactNo) {
}
