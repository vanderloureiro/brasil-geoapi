package com.br.brasilgeoapi.integracao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.brasilgeoapi.domain.RetornoDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GeoApiControllerTest {
    
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void buscarTodasCidadesJsonTest() {

        ResponseEntity<RetornoDto[]> response = this.testRestTemplate
            .exchange("/geoapi", HttpMethod.GET, null, RetornoDto[].class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void buscarTodasCidadesCsvTest() {

        ResponseEntity<?> response = this.testRestTemplate
            .exchange("/geoapi/csv", HttpMethod.GET, null, Void.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void buscarIdCidadePorNomeTest() {

        ResponseEntity<String> response = this.testRestTemplate
            .exchange("/geoapi/municipio/Jaguaruana", HttpMethod.GET, null, String.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void buscarIdCidadePorNomeErroTest() {

        ResponseEntity<String> response = this.testRestTemplate
            .exchange("/geoapi/municipio/tangamandapio", HttpMethod.GET, null, String.class);
    
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
