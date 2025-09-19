package com.bofa.customerapi.repositories;

import com.bofa.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IndividualRepository  extends JpaRepository<Individual,String> {

    List<Individual> findByFullName_FirstName(String firstName);
}
