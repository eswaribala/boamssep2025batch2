package com.bofa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long accountNo;
    private FullName fullName;

    private Address address;

    private String email;
    private String password;

    private String contactNo;




}
