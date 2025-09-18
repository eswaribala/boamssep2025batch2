package com.bofa.customerapi.services;

import com.bofa.customerapi.exceptions.CustomerNotFoundException;
import com.bofa.customerapi.models.Individual;
import com.bofa.customerapi.repositories.IndividualRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class IndividualServiceImpl implements IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topicName}")
    private String topicName;
    @Override
    public Individual save(Individual individual) {
        return this.individualRepository.save(individual);

    }

    @Override
    public Individual findById(String id) {
        return this.individualRepository.findById(id).orElseThrow(()->new
                CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Individual> findByFirstName(String firstName) {
        return this.individualRepository.findByFullName_FirstName(firstName);
    }

    @Override
    public List<Individual> findAll() {
        return individualRepository.findAll();
    }

    @Override
    public Individual updateIndividual(String id, String email, String contactNo, String password) {
       Individual individual=this.individualRepository.findById(id)
               .orElseThrow(()->new CustomerNotFoundException("Customer not found"));
        if (individual != null) {

            individual.setEmail(email);
            individual.setContactNo(contactNo);
            individual.setPassword(password);
            return individualRepository.save(individual);
        }
        return null;
    }

    @Override
    public boolean deleteIndividual(String id) {
        boolean status = false;

        Individual individual = this.individualRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        if (individual != null) {
            this.individualRepository.deleteById(id);
            status = true;
        }
        return status;
    }

    @Override
    public CompletableFuture<SendResult<String, Object>> publishToTopic(String id) throws JsonProcessingException {
        Individual individual = this.individualRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        if (individual != null) {
            ObjectWriter ow = new ObjectMapper().writer();
            String json= ow.writeValueAsString(individual);
            return kafkaTemplate.send(topicName, json);
        }
        return null;
    }
}
