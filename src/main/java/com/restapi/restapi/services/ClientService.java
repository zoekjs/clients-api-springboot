package com.restapi.restapi.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.restapi.restapi.dto.ClientResponseDto;
import com.restapi.restapi.dto.CreateClientDto;
import com.restapi.restapi.dto.DeleteClientDto;
import com.restapi.restapi.mapper.ClientResponseMapper;
import com.restapi.restapi.model.entity.Client;
import com.restapi.restapi.model.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientResponseMapper clientResponseMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDto> findAll() {
        List<Client> find = (List<Client>) clientRepository.findAll();

        return find.stream().map(client -> clientResponseMapper.toDto(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto create(CreateClientDto body) {
        boolean emailExists = checkIfEmailExists(body.getEmail());
        if (emailExists) throw new ResponseStatusException(HttpStatus.CONFLICT, "User email already exists");

        Client clientDBO = Client.builder()
                .name(body.getName())
                .lastName(body.getLastName())
                .email(body.getEmail())
                .createdAt(new Date())
                .build();

        Client response = clientRepository.save(clientDBO);

        return clientResponseMapper.toDto(response);
    }

    @Transactional
    public boolean delete(DeleteClientDto body) {
        boolean emailExists = checkIfEmailExists(body.getEmail());
        if (!emailExists) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User email doesnt exists");

        return (clientRepository.deleteByEmail(body.getEmail()) == 1);
    }

    private boolean checkIfEmailExists(String email) {
        return clientRepository.existsByEmail(email);

    }


}
