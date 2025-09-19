package com.bofa.customerapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bofa_Individual")
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class Individual extends Customer {
   @Enumerated(EnumType.STRING)
   @Column(name="Gender")
   private Gender gender;

   @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE)
   @Column(name="Birth_Date")
   private LocalDate birthDate;


}
