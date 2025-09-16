package com.bofa.customerapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Bofa_Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@SuperBuilder
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @AccountNo
    @Column(name="Account_No")
    protected String accountNo;

    @Embedded
    protected  FullName fullName;

    @Column(name="Email",nullable = false,length = 150,unique = true)
    protected  String email;

    @Column(name="Contact_No",nullable = false,length = 15)
    protected  String contactNo;

    @Column(name="Password",nullable = false,length = 10)
    protected  String password;


}
