package com.br.brasilgeoapi.integracao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.br.brasilgeoapi.client.ServicoDadosIbgeClient;
import com.br.brasilgeoapi.domain.EstadoDto;
import com.br.brasilgeoapi.domain.MunicipioDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServicoDadosIBGEClientTest {
    
    @Autowired
    private ServicoDadosIbgeClient client;

    @Test
    public void buscarTodosEstadosTest() {
        List<EstadoDto> estadosBuscados = client.buscarTodosEstados();
        assertEquals(estadosBuscados.isEmpty(), false);
    }

    @Test
    public void buscarTodosMunicipiosTest() {
        List<MunicipioDto> municipiosBuscados = client.buscarTodosMunicipios();
        assertEquals(municipiosBuscados.isEmpty(), false);
    }

    @Test
    public void buscarMunicipiosPorEstadoTest() {
        List<MunicipioDto> municipiosBuscados = client.buscarMunicipiosPorUF("CE");
        assertEquals(municipiosBuscados.isEmpty(), false);
    }

}
