package com.bofa.customerapi.services;

import com.bofa.customerapi.models.Individual;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.kafka.support.SendResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IndividualService {

    Individual save(Individual individual);
    Individual findById(String id);
    List<Individual> findByFirstName(String name);
    List<Individual> findAll();

    Individual updateIndividual(String id, String email, String contactNo, String password);

    boolean deleteIndividual(String id);

    CompletableFuture<SendResult<String,Object>> publishToTopic(String id) throws JsonProcessingException;




}
