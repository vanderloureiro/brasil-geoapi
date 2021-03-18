package com.br.brasilgeoapi.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.br.brasilgeoapi.domain.RetornoDto;
import com.br.brasilgeoapi.exception.BadRequestException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GeradorCsvService {

    private PesquisaService pesquisaService;

    public GeradorCsvService(PesquisaService pesquisaService) {
        this.pesquisaService = pesquisaService;
    }

    public void gerarCsv(HttpServletResponse response) {
        log.info("Gerando CSV...");
        response.setContentType("text/csv; charset=UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=download.csv");
        try {
            ServletOutputStream os = response.getOutputStream();
            os.write(this.gerarCabecalho().getBytes("UTF-8"));
            os.write(this.gerarConteudo().getBytes("UTF-8"));
            response.flushBuffer();
        } catch (IOException e) {
            log.error("Erro na criação de CSV");
            throw new BadRequestException("Erro na criação de CSV");
        }
    }
    
    private String gerarConteudo() {
        List<RetornoDto> registros = this.pesquisaService.buscarTodos();
        StringBuilder linhas = new StringBuilder();
        registros.forEach(registro -> {
            linhas.append(this.gerarLinha(registro));
        });
        return linhas.toString();
    }

    private String gerarCabecalho() {
        StringBuilder cabecalho = new StringBuilder();
        cabecalho.append("idEstado,");
        cabecalho.append("siglaEstado,");
        cabecalho.append("regiaoNome,");
        cabecalho.append("nomeCidade,");
        cabecalho.append("nomeMesorregiao,");
        cabecalho.append("nomeFormatado,");
        cabecalho.append("\n");
        return cabecalho.toString();
    }

    private String gerarLinha(RetornoDto dto) {
        StringBuilder linha = new StringBuilder();
        linha.append(dto.getIdEstado() + ",");
        linha.append(dto.getSiglaEstado() + ",");
        linha.append(dto.getRegiaoNome() + ",");
        linha.append(dto.getNomeCidade() + ",");
        linha.append(dto.getNomeMesorregiao() + ",");
        linha.append(dto.getNomeFormatado() + ",");
        linha.append("\n");
        return linha.toString();
    }
    
}
