package com.br.brasilgeoapi.domain;

import lombok.Data;

@Data
public class MicrorregiaoDto {
    
    private Long id;
    private String nome;
    private MesorregiaoDto mesorregiao;
}
