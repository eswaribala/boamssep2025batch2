package com.bofa.customerapi.controllers;

import com.bofa.customerapi.dtos.GenericResponse;
import com.bofa.customerapi.dtos.IndividualMapper;
import com.bofa.customerapi.dtos.IndividualRequest;
import com.bofa.customerapi.dtos.IndividualResponse;
import com.bofa.customerapi.models.FullName;
import com.bofa.customerapi.models.Individual;
import com.bofa.customerapi.services.IndividualService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.websocket.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("individuals")
public class IndividualController {

    @Autowired
    private IndividualService individualService;

    @Autowired
    private IndividualMapper individualMapper;

    @PostMapping("/v1.0")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<GenericResponse> addIndividual(@RequestBody IndividualRequest individualRequest) {

        //DTO to Entity
        Individual individual = Individual.builder()
                .fullName(FullName.builder()
                        .firstName(individualRequest.getFullName().getFirstName())
                        .middleName(individualRequest.getFullName().getMiddleName())
                        .lastName(individualRequest.getFullName().getLastName())
                        .build())
                .email(individualRequest.getEmail())
                .contactNo(individualRequest.getContactNo())
                .password(individualRequest.getPassword())
                .gender(individualRequest.getGender())
                .birthDate(individualRequest.getBirthDate())
                .build();
        Individual individualData = individualService.save(individual);
        IndividualResponse individualResponse=null;
        //Entity to DTO
        if (individualData != null) {

            individualResponse=individualMapper.toDTos(individualData);
            return ResponseEntity.status(HttpStatus.CREATED).body(new
                    GenericResponse<>(individualResponse));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                    GenericResponse<>("Individual not created"));
        }



    }



    @GetMapping("/v1.0")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})


    public ResponseEntity<GenericResponse> fetchAllIndividuals() {
       List<Individual> individuals = individualService.findAll();
       List<IndividualResponse> individualResponses=individualMapper.toDTos(individuals);
         return ResponseEntity.status(HttpStatus.OK).body(new
                GenericResponse<>(individualResponses));
    }

    @GetMapping("/v1.0/{accountNo}")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<GenericResponse> fetchIndividualById(@PathVariable String accountNo) {
        Individual individual = individualService.findById(accountNo);
        if(individual==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
                    GenericResponse<>("Individual not found"));
        }else {
            IndividualResponse individualResponse = individualMapper.toDTos(individual);
            return ResponseEntity.status(HttpStatus.OK).body(new
                    GenericResponse<>(individualResponse));
        }
    }

    @GetMapping("/v1.0/firstName/{firstName}")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<GenericResponse> fetchIndividualByFirstName(@PathVariable("firstName") String firstName) {
        List<Individual> individuals = individualService.findByFirstName(firstName);

        if(individuals==null || individuals.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
                    GenericResponse<>("Individual not found"));
        }else {
            List<IndividualResponse> individualResponses = individualMapper.toDTos(individuals);
            return ResponseEntity.status(HttpStatus.OK).body(new
                    GenericResponse<>(individualResponses));
        }
    }


    @PutMapping("/v1.0")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<GenericResponse> updateIndividualById(@RequestParam("accountNo") String accountNo,@RequestParam("email") String email,
                                                               @RequestParam("contactNo") String contactNo,@RequestParam("password") String password){
        Individual individual = individualService.updateIndividual(accountNo,email,contactNo,password);
        if(individual==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
                    GenericResponse<>("Individual not found"));
        }else {
            IndividualResponse individualResponse = individualMapper.toDTos(individual);
            return ResponseEntity.status(HttpStatus.OK).body(new
                    GenericResponse<>(individualResponse));
        }
    }

    @DeleteMapping("/v1.0/{accountNo}")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<GenericResponse> deleteIndividual(@PathVariable String accountNo){
        boolean status= individualService.deleteIndividual(accountNo);
        if(status){
            return ResponseEntity.status(HttpStatus.OK).body(new
                    GenericResponse<>("Individual deleted successfully"));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
                    GenericResponse<>("Individual not found"));
        }
        }






}
