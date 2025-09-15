package com.bofa.customerapi.services;

import com.bofa.customerapi.models.Individual;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IndividualService {

    Individual save(Individual individual);
    Individual findById(long id);
    List<Individual> findByFirstName(String name);
    List<Individual> findAll();

    Individual updateIndividual(long id, String email, String contactNo, String password);

    boolean deleteIndividual(long id);




}
