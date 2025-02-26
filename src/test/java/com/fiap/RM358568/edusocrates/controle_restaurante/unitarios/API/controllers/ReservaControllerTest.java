package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.reserva.ReservaController;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.ReservaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservaControllerTest {

    @Mock
    private ReservaUseCase reservaUseCase;

    @InjectMocks
    private ReservaController reservaController;

    @Test
    void buscarPorId_deveRetornarReservaResponse_quandoReservaExistir() {
        Long id = 1L;
        ReservaResponse reservaResponse = new ReservaResponse(id, "2024-05-03", "19:00", 4, "Confirmada", 1L, 1L, 1L);
        when(reservaUseCase.buscarPorRestaurante(id)).thenReturn(Arrays.asList(reservaResponse));

        ResponseEntity<List<ReservaResponse>> response = reservaController.buscarPorRestaurante(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void salvar_deveRetornarReservaResponse_quandoReservaForSalva() {
        ReservaRequest reservaRequest = new ReservaRequest(1L, 1L, 1L, "2024-05-03", "19:00", 4, "Confirmada");
        ReservaResponse reservaResponse = new ReservaResponse(1L, "2024-05-03", "19:00", 4, "Confirmada", 1L, 1L, 1L);
        when(reservaUseCase.salvar(reservaRequest)).thenReturn(reservaResponse);

        ResponseEntity<ReservaResponse> response = reservaController.salvar(reservaRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservaResponse, response.getBody());
    }


}
