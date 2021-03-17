package com.br.brasilgeoapi.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 6612810082421732213L;

    public BadRequestException(String mensagem) {
        super(mensagem);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
