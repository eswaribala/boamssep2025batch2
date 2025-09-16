package com.bofa.customerapi.services;

import com.bofa.customerapi.exceptions.CustomerNotFoundException;
import com.bofa.customerapi.models.Individual;
import com.bofa.customerapi.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualServiceImpl implements IndividualService {

    @Autowired
    private IndividualRepository individualRepository;


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
}
