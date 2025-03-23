package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.controller;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
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
class UsuarioControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarPorId_deveRetornarUsuario() {
        Long id = 1L; // Certifique-se de que este ID exista no banco de dados de teste
        ResponseEntity<UsuarioResponse> response = restTemplate.getForEntity("/usuarios/" + id, UsuarioResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void salvar_deveCriarNovoUsuario() {
        UsuarioRequest request = new UsuarioRequest("Nome Teste", "email@teste.com", "123456789", List.of(1L), List.of(2L));
        ResponseEntity<UsuarioResponse> response = restTemplate.postForEntity("/usuarios", request, UsuarioResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}