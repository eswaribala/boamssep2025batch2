package com.bofa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
    private long accountNo;
    @Autowired
    private FullName fullName;
    @Autowired
    private Address address;

    private String email;
    private String password;

    private String contactNo;




}
