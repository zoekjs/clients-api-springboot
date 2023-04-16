package com.restapi.restapi.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class ClientResponseDto {
    private String name;
    private String lastName;
    private String email;
    private Date createdAt;
}
