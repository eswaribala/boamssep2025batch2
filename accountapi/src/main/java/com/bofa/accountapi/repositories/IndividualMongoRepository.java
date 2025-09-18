package com.bofa.accountapi.repositories;

import com.bofa.accountapi.models.Individual;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndividualMongoRepository extends MongoRepository<Individual, String> {
}
