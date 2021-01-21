package com.restapi.restapi.model.services;

import java.util.List;

import com.restapi.restapi.model.entity.Client;
import com.restapi.restapi.model.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService implements IClientService {
  
  @Autowired
  private ClientRepository clientRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Client> findAll() {
    return (List<Client>) clientRepository.findAll();
  }

}
