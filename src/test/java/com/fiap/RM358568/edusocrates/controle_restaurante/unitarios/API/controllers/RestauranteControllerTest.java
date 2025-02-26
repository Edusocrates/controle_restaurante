package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.RestauranteController;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestauranteControllerTest {

    @Mock
    private RestauranteUseCase restauranteUseCase;

    @InjectMocks
    private RestauranteController restauranteController;

    @Test
    void buscarPorId_deveRetornarRestauranteResponse_quandoRestauranteExistir() {
        Long id = 1L;
        List<MesaResponse> mesas = new ArrayList<>();
        RestauranteResponse restauranteResponse = new RestauranteResponse(id, "Nome Teste", "Localizacao Teste", "Tipo Cozinha Teste", "Horarios Teste", 50, mesas);
        when(restauranteUseCase.buscarPorId(id)).thenReturn(restauranteResponse);

        ResponseEntity<RestauranteResponse> response = restauranteController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restauranteResponse, response.getBody());
    }

    @Test
    void salvar_deveRetornarRestauranteResponse_quandoRestauranteForSalvo() {
        List<MesaResponse> mesas = new ArrayList<>();
        RestauranteRequest restauranteRequest = new RestauranteRequest("Nome Teste", "Localizacao Teste", "Tipo Cozinha Teste", "Horarios Teste", 50, new ArrayList<>());
        RestauranteResponse restauranteResponse = new RestauranteResponse(1L, "Nome Teste", "Localizacao Teste", "Tipo Cozinha Teste", "Horarios Teste", 50, mesas);
        when(restauranteUseCase.salvar(restauranteRequest)).thenReturn(restauranteResponse);

        ResponseEntity<RestauranteResponse> response = restauranteController.salvar(restauranteRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restauranteResponse, response.getBody());
    }

    @Test
    void buscarTodos_deveRetornarListaDeRestauranteResponse() {
        List<MesaResponse> mesas = new ArrayList<>();
        RestauranteResponse restaurante1 = new RestauranteResponse(1L, "Nome 1", "Localizacao 1", "Tipo 1", "Horarios 1", 50, mesas);
        RestauranteResponse restaurante2 = new RestauranteResponse(2L, "Nome 2", "Localizacao 2", "Tipo 2", "Horarios 2", 100, mesas);
        List<RestauranteResponse> restaurantes = Arrays.asList(restaurante1, restaurante2);

        when(restauranteUseCase.buscarTodos()).thenReturn(restaurantes);

        ResponseEntity<List<RestauranteResponse>> response = restauranteController.buscarTodos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurantes, response.getBody());
    }
}