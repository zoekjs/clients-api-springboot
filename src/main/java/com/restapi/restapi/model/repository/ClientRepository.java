package com.restapi.restapi.model.repository;

import com.restapi.restapi.model.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
  
}
