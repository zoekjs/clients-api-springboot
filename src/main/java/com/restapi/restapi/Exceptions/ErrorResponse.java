package com.restapi.restapi.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.Map;

@AllArgsConstructor
@Builder
@Data
public class ErrorResponse {
    private String message;
    private int statusCode;
    private Map<String, String> details;

}
