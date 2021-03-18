package com.br.brasilgeoapi.controller;

import java.util.List;

import com.br.brasilgeoapi.client.ServicoDadosIbgeClient;
import com.br.brasilgeoapi.domain.EstadoDto;
import com.br.brasilgeoapi.domain.RetornoDto;
import com.br.brasilgeoapi.service.PesquisaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api("GeoApi Controller")
@RequestMapping("/geoapi")
@RestController
public class GeoApiController {

    private ServicoDadosIbgeClient client;
    private PesquisaService service;

    public GeoApiController(ServicoDadosIbgeClient client, PesquisaService service) {
        this.client = client;
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<RetornoDto>> buscaTodos() {
        return ResponseEntity.ok().body(this.service.buscarTodos());
    }

    @GetMapping("/csv")
    public ResponseEntity<List<EstadoDto>> getEstados() {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/municipio/{nomeCidade}")
    public ResponseEntity<Long> buscarIdMunicipioPorNome(@PathVariable String nomeCidade) {
        return ResponseEntity.ok().body(this.service.buscarIdCidadePorNome(nomeCidade));
    }

}
