package com.bofa.customerapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Bofa_Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;

    @Column(name="Door_No",nullable = false,length = 5)
    private String doorNo;
    @Column(name="Street_Name",nullable = false,length = 150)
    private String streetName;
    @Column(name="City",nullable = false,length = 50)
    private String city;

    @Column(name="State",nullable = false,length = 5)
    private String state;


    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Account_No"),
            name = "Account_No_FK")

    private Customer customer;

}
