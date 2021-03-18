package com.br.brasilgeoapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.br.brasilgeoapi.domain.RetornoDto;
import com.br.brasilgeoapi.service.PesquisaCsvService;
import com.br.brasilgeoapi.service.PesquisaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api("GeoApi Controller")
@RequestMapping("/geoapi")
@RestController
public class GeoApiController {

    private PesquisaService service;
    private PesquisaCsvService pesquisaCsvService;

    public GeoApiController(PesquisaService service, PesquisaCsvService pesquisaCsvService) {
        this.service = service;
        this.pesquisaCsvService = pesquisaCsvService;
    }
    
    @GetMapping
    @ApiOperation(value = "Busca todas as cidades e estados e retorna em JSON", response = RetornoDto[].class)
    public ResponseEntity<List<RetornoDto>> buscarTodos() {
        return ResponseEntity.ok().body(this.service.buscarTodos());
    }

    @GetMapping("/csv")
    @ApiOperation(value = "Busca todas as cidades e estados e retorna em CSV")
    public ResponseEntity<?> buscarTodosEmCsv(HttpServletResponse response) {
        this.pesquisaCsvService.gerarCsv(response);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/municipio/{nomeCidade}")
    @ApiOperation(value = "Busca uma cidade por nome e retorna seu ID", response = Long.class)
    public ResponseEntity<Long> buscarIdMunicipioPorNome(@PathVariable String nomeCidade) {
        return ResponseEntity.ok().body(this.service.buscarIdCidadePorNome(nomeCidade));
    }

}
