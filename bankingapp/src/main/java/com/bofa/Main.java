package com.bofa;

import com.bofa.models.Address;
import com.bofa.models.Customer;
import com.bofa.models.FullName;
import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      //Container
      ApplicationContext context = new ClassPathXmlApplicationContext("banking-config.xml");

      //faker
        Faker faker = new Faker();

      //bean instances
      //loose coupling
        FullName fullName = (FullName) context.getBean("fullName");
        //DI
        fullName.setFirstName(faker.name().firstName());
        fullName.setLastName(faker.name().lastName());
        fullName.setMiddleName(faker.name().nameWithMiddle());

        Address address = (Address) context.getBean("address");
        address.setDoorNo(faker.address().buildingNumber());
        address.setCity(faker.address().city());
        address.setState(faker.address().state());
        address.setStreetName(faker.address().streetName());
        Customer customer = (Customer) context.getBean("customer");
        customer.setAccountNo(faker.number().numberBetween(100000,10000000));
        customer.setEmail(faker.internet().emailAddress());
        customer.setPassword(faker.internet().password());
        customer.setAddress(address);
        customer.setFullName(fullName);
        customer.setEmail(faker.internet().emailAddress());
        customer.setContactNo(faker.phoneNumber().phoneNumber());
        System.out.println("Customer"+customer);

    }
}