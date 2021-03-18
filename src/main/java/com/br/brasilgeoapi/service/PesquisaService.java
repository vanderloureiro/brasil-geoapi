package com.br.brasilgeoapi.service;

import java.util.ArrayList;
import java.util.List;

import com.br.brasilgeoapi.client.ServicoDadosIbgeClient;
import com.br.brasilgeoapi.domain.EstadoDto;
import com.br.brasilgeoapi.domain.MunicipioDto;
import com.br.brasilgeoapi.domain.RetornoDto;

import org.springframework.stereotype.Service;

@Service
public class PesquisaService {
    
    private ServicoDadosIbgeClient client;

    public PesquisaService(ServicoDadosIbgeClient client) {
        this.client = client;
    }

    public List<RetornoDto> buscarTodos() {
        List<EstadoDto> estadosBuscados = this.client.buscarTodosEstados();
        ArrayList<RetornoDto> listaRetorno = new ArrayList<>();
        estadosBuscados.forEach(estado -> {
            List<MunicipioDto> municipiosBuscados = this.client.buscarMunicipiosPorUF(estado.getSigla());
            listaRetorno.addAll(this.gerarListaRetornoPorEstado(municipiosBuscados, estado));
        });
        return listaRetorno;
    }

    private List<RetornoDto> gerarListaRetornoPorEstado(List<MunicipioDto> municipios, EstadoDto estado) {
        ArrayList<RetornoDto> lista = new ArrayList<>();
        municipios.forEach(municipio -> {
            lista.add(this.gerarRetornoDtoIndividual(municipio, estado));
        });
        return lista;
    }

    private RetornoDto gerarRetornoDtoIndividual(MunicipioDto municipio, EstadoDto estado) {
        RetornoDto retorno = new RetornoDto();
        retorno.setIdEstado(estado.getId());
        retorno.setSiglaEstado(estado.getSigla());
        retorno.setRegiaoNome(estado.getRegiao().getNome());
        retorno.setNomeCidade(municipio.getNome());
        retorno.setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
        retorno.setNomeFormatado(municipio.getNome()+"/"+estado.getSigla());
        return retorno;
    }
}
