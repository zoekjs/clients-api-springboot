package com.restapi.restapi.controllers;

import java.util.List;

import com.restapi.restapi.model.entity.Client;
import com.restapi.restapi.model.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/clients")
public class ClienteRestController {
  
  @Autowired
  private ClientService clientService;

  @GetMapping
  public List<Client> index() {
    return clientService.findAll();
  }

}
