package com.restapi.restapi.mapper;

import com.restapi.restapi.dto.ClientResponseDto;
import com.restapi.restapi.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientResponseMapper {
    ClientResponseDto toDto(Client client);
}
