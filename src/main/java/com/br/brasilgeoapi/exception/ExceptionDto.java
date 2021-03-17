package com.br.brasilgeoapi.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {
    
    private HttpStatus status;
    private String mensagem;
}
