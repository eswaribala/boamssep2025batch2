package com.bofa.customerapi.models;

import com.github.javafaker.Faker;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import java.util.EnumSet;

public class CustomIdGenerator implements BeforeExecutionGenerator {
    private Faker faker;
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o, Object o1, EventType eventType) {
       faker = new Faker();
        return "98765"+faker.number().randomNumber(8,true);
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }
}
