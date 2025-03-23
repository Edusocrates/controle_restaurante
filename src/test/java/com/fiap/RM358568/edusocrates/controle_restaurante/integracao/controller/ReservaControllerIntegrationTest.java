package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.controller;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
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
class ReservaControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeReservas() {
        Long restauranteId = 1L;
        ResponseEntity<List> response = restTemplate.getForEntity("/reservas/restaurante/" + restauranteId, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void salvar_deveCriarNovaReserva() {
        ReservaRequest request = new ReservaRequest(1L, 1L, 1L, "2024-05-03", "19:00", 4, "Confirmada");
        ResponseEntity<ReservaResponse> response = restTemplate.postForEntity("/reservas", request, ReservaResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}