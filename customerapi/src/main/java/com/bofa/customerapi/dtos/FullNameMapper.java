package com.bofa.customerapi.dtos;

import com.bofa.customerapi.models.FullName;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FullNameMapper {
    FullNameResponse toDTos(FullName fullName) ;
}
