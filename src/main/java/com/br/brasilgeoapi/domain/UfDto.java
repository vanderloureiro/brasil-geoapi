package com.br.brasilgeoapi.domain;

import lombok.Data;

@Data
public class UfDto {
    
    private Long id;
    private String sigla;
    private String nome;
    private RegiaoDto regiao;
}
