package com.bofa.accountapi.services;


import com.bofa.accountapi.models.Individual;
import com.bofa.accountapi.repositories.IndividualMongoRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "bofacustomerdata", groupId = "saga-account-group")
@Slf4j
public class CustomerConsumerServiceImpl implements CustomerConsumerService {

    @Autowired
    private IndividualMongoRepository individualMongoRepository;

    @Override
    @KafkaHandler(isDefault = true)
    public void consumeCustomerData(String data) {

        log.info("Received customer data: {}", data);
        Gson gson = new Gson();
        Individual individual = gson.fromJson(data, Individual.class);
        log.info("Parsed Individual: {}", individual);
        individualMongoRepository.save(individual);
        log.info("Individual saved to MongoDB: {}", individual);


    }
}
