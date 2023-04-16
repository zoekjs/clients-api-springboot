package com.restapi.restapi.services;

import java.util.List;

import com.restapi.restapi.dto.ClientResponseDto;
import com.restapi.restapi.dto.CreateClientDto;
import com.restapi.restapi.dto.DeleteClientDto;

public interface IClientService {

  public List<ClientResponseDto> findAll();

  public ClientResponseDto create(CreateClientDto client);

  public boolean delete(DeleteClientDto body);

}
