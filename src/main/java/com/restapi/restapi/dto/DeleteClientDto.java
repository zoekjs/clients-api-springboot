package com.restapi.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteClientDto {
    @NotEmpty
    @Email
    String email;
}
