package com.bofa.customerapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="Bofa_Corporate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class Corporate extends Customer {

    @Enumerated(EnumType.STRING)
    @Column(name="Company_Type")
    private CompanyType companyType;


}
