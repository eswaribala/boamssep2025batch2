package com.bofa.customerapi.services;

import com.bofa.customerapi.models.Individual;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IndividualService {

    Individual save(Individual individual);
    Individual findById(String id);
    List<Individual> findByFirstName(String name);
    List<Individual> findAll();

    Individual updateIndividual(String id, String email, String contactNo, String password);

    boolean deleteIndividual(String id);




}
