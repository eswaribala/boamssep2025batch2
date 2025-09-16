package com.bofa.customerapi.controllers;

import com.bofa.customerapi.dtos.GenericResponse;
import com.bofa.customerapi.dtos.IndividualMapper;
import com.bofa.customerapi.dtos.IndividualRequest;
import com.bofa.customerapi.dtos.IndividualResponse;
import com.bofa.customerapi.models.FullName;
import com.bofa.customerapi.models.Individual;
import com.bofa.customerapi.services.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("individuals")
public class IndividualController {

    @Autowired
    private IndividualService individualService;

   // @Autowired
   // private IndividualMapper individualMapper;

    @PostMapping("/v1.0")
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

         //   individualResponse=individualMapper.toDTos(individualData);
            return ResponseEntity.status(HttpStatus.CREATED).body(new
                    GenericResponse<>(individualData));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                    GenericResponse<>("Individual not created"));
        }



    }


    @GetMapping("/v1.0")
    public ResponseEntity<GenericResponse> fetchAllIndividuals() {
       List<Individual> individuals = individualService.findAll();
    //   List<IndividualResponse> individualResponses=individualMapper.toDTos(individuals);
         return ResponseEntity.status(HttpStatus.OK).body(new
                GenericResponse<>(individuals));
    }



}
