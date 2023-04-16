package com.restapi.restapi.controllers;

import java.util.List;

import com.restapi.restapi.dto.ClientResponseDto;
import com.restapi.restapi.dto.CreateClientDto;
import com.restapi.restapi.dto.DeleteClientDto;
import com.restapi.restapi.services.ClientService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Tag(name = "Clients", description = "Clients Endpoints")
@RequestMapping("api/clients")
@Slf4j
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseDto> index() {
        return clientService.findAll();
    }


    @ApiResponse(responseCode = "201", description = "Success", content = {@Content(mediaType = "application/json")})
    @ApiResponse(responseCode = "409", description = "Conflict", content = {@Content(mediaType = "application/json")})
    @PostMapping()
    public ClientResponseDto create(@Valid @RequestBody CreateClientDto body) {
        return clientService.create(body);
    }

    @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")})
    @DeleteMapping()
    public boolean delete(@Valid @RequestBody DeleteClientDto email) {
        return clientService.delete(email);
    }

}
