package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.API.controllers;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.mesa.MesaController;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.MesaUseCase;
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
class MesaControllerTest {

    @Mock
    private MesaUseCase mesaUseCase;

    @InjectMocks
    private MesaController mesaController;

    @Test
    void buscarPorId_deveRetornarMesaResponse_quandoMesaExistir() {
        Long id = 1L;
        List<Long> reservasIds = new ArrayList<>();
        MesaResponse mesaResponse = new MesaResponse(id, 1, 4, "Disponivel", 1L, reservasIds);
        when(mesaUseCase.buscarPorRestaurante(id)).thenReturn(Arrays.asList(mesaResponse));

        ResponseEntity<List<MesaResponse>> response = mesaController.buscarPorRestaurante(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Arrays.asList(mesaResponse), response.getBody());
    }

    @Test
    void salvar_deveRetornarMesaResponse_quandoMesaForSalva() {
        List<Long> reservasIds = new ArrayList<>();
        reservasIds.add(1L);
        MesaRequest mesaRequest = new MesaRequest(1, 4, "Disponivel", 1L, reservasIds);
        MesaResponse mesaResponse = new MesaResponse(1L, 1, 4, "Disponivel", 1L, reservasIds);
        when(mesaUseCase.salvar(mesaRequest)).thenReturn(mesaResponse);

        ResponseEntity<MesaResponse> response = mesaController.salvar(mesaRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mesaResponse, response.getBody());
    }


}