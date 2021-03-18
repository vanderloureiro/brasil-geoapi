package com.br.brasilgeoapi.domain;

import lombok.Data;

@Data
public class RetornoDto {
    
    private Long idEstado;
    private String siglaEstado;
    private String regiaoNome;
    private String nomeCidade;
    private String nomeMesorregiao;
    private String nomeFormatado; // {cidade/UF}
}
