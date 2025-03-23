package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.controller;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MesaControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeMesas() {
        Long restauranteId = 1L;
        ResponseEntity<List> response = restTemplate.getForEntity("/mesas/restaurante/" + restauranteId, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void salvar_deveCriarNovaMesa() {
        MesaRequest request = new MesaRequest(1, 4, "Disponivel", 1L, List.of());
        ResponseEntity<MesaResponse> response = restTemplate.postForEntity("/mesas", request, MesaResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}