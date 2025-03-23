package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.controller;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
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
class RestauranteControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarTodos_deveRetornarListaDeRestaurantes() {
        ResponseEntity<List> response = restTemplate.getForEntity("/restaurantes", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void buscarPorId_deveRetornarRestaurante() {
        Long id = 1L;
        ResponseEntity<RestauranteResponse> response = restTemplate.getForEntity("/restaurantes/" + id, RestauranteResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void salvar_deveCriarNovoRestaurante() {
        RestauranteRequest request = new RestauranteRequest("Nome Teste", "Localizacao Teste", "Tipo Cozinha Teste", "Horarios Teste", 50, List.of());
        ResponseEntity<RestauranteResponse> response = restTemplate.postForEntity("/restaurantes", request, RestauranteResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
