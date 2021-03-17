package com.br.brasilgeoapi.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -477923137179305586L;

    public NotFoundException(String mensagem) {
        super(mensagem);
    }

    public NotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
