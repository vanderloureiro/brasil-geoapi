package com.br.brasilgeoapi.client;

import java.util.Arrays;
import java.util.List;

import com.br.brasilgeoapi.domain.EstadoDto;
import com.br.brasilgeoapi.domain.MunicipioDto;
import com.br.brasilgeoapi.exception.BadRequestException;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServicoDadosIbgeClient {

    private String localidadeApiUrl = "https://servicodados.ibge.gov.br/api/v1/localidades";
    private RestTemplate restTemplate;

    public ServicoDadosIbgeClient() {
        this.restTemplate = new RestTemplate();
    }
    
    public List<EstadoDto> buscarTodosEstados() {
        String url = this.localidadeApiUrl + "/estados";

        ResponseEntity<EstadoDto[]> response = this.restTemplate
            .exchange(url, HttpMethod.GET, null, EstadoDto[].class);
        
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BadRequestException("Erro na consulta de ServiçoDadosIBGE");
        }
        return Arrays.asList(response.getBody());
    }

    public List<MunicipioDto> buscarMunicipiosPorUF(String uf) {
        String url = this.localidadeApiUrl + "/estados/" + uf + "/municipios";

        ResponseEntity<MunicipioDto[]> response = this.restTemplate
            .exchange(url, HttpMethod.GET, null, MunicipioDto[].class);
        
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BadRequestException("Erro na consulta de ServiçoDadosIBGE");
        }
        return Arrays.asList(response.getBody());
    }

    public List<MunicipioDto> buscarTodosMunicipios() {
        String url = this.localidadeApiUrl + "/municipios";

        ResponseEntity<MunicipioDto[]> response = this.restTemplate
            .exchange(url, HttpMethod.GET, null, MunicipioDto[].class);
        
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BadRequestException("Erro na consulta de ServiçoDadosIBGE");
        }
        return Arrays.asList(response.getBody());
    }
}
