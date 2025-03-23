package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.controller;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
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
class AvaliacaoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeAvaliacoes() {
        Long restauranteId = 1L;
        ResponseEntity<List> response = restTemplate.getForEntity("/avaliacoes/restaurante/" + restauranteId, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void salvar_deveCriarNovaAvaliacao() {
        AvaliacaoRequest request = new AvaliacaoRequest(1L, 1L, 5, "Excelente", "2024-05-03");
        ResponseEntity<AvaliacaoResponse> response = restTemplate.postForEntity("/avaliacoes", request, AvaliacaoResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}