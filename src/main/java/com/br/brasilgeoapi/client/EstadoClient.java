package com.br.brasilgeoapi.client;

import java.util.List;

import com.br.brasilgeoapi.domain.EstadoDto;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EstadoClient {

    private String resourceUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
    private RestTemplate restTemplate;

    public EstadoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<EstadoDto> buscarTodosEstados() {

        /*
        ResponseEntity<EstadoDto[]> response = this.restTemplate
            .exchange(this.resourceUrl, HttpMethod.GET, null, EstadoDto[].class);
        */
        return null;
    }
}
