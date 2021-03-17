package com.br.brasilgeoapi.domain;

import lombok.Data;

@Data
public class MesorregiaoDto {
    
    private Long id;
    private String nome;
    private UfDto uf;
}
