package com.br.brasilgeoapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MesorregiaoDto {
    
    private Long id;
    private String nome;
    @JsonProperty("UF")
    private UfDto uf;
}
