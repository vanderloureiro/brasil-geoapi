package com.br.brasilgeoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> NotFoundException(NotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage())
        );
    }

    @ExceptionHandler(Forbidden.class)
    public ResponseEntity<ExceptionDto> ForbiddenException(Forbidden e){

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
            new ExceptionDto(HttpStatus.FORBIDDEN, e.getMessage())
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> BadRequestException(BadRequestException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDto> IllegalArgumentException(IllegalArgumentException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

}
