package com.bofa.customerapi.dtos;

import com.bofa.customerapi.models.Individual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = { FullNameMapper.class })
public interface IndividualMapper {

    @Mapping(source = "fullName", target = "fullNameResponse")
    IndividualResponse toDTos(Individual individual);

    List<IndividualResponse> toDTos(List<Individual> individuals);

}
