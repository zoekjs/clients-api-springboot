package com.restapi.restapi.model.services;

import java.util.List;

import com.restapi.restapi.model.entity.Client;

public interface IClientService {
  
  public List<Client> findAll();

}
