package com.br.brasilgeoapi.domain;

import lombok.Data;

@Data
public class MunicipioDto {
    
    private Long id;
    private String nome;
    private MicrorregiaoDto microrregiao;
}
