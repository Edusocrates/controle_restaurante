package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.API.controllers;



import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.avaliacao.AvaliacaoController;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.AvaliacaoUseCase;
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
class AvaliacaoControllerTest {

    @Mock
    private AvaliacaoUseCase avaliacaoUseCase;

    @InjectMocks
    private AvaliacaoController avaliacaoController;

    @Test
    void buscarPorId_deveRetornarAvaliacaoResponse_quandoAvaliacaoExistir() {
        Long id = 1L;
        UsuarioResponse usuarioResponse = new UsuarioResponse(1L, "Usuario", "usuario@email.com", "123456789", new ArrayList<>(), new ArrayList<>());
        List<MesaResponse> mesaResponses = new ArrayList<>();
        RestauranteResponse restauranteResponse = new RestauranteResponse(1L, "Restaurante", "Localizacao", "Tipo", "Horarios", 10, mesaResponses);

        AvaliacaoResponse avaliacaoResponse = new AvaliacaoResponse(id, "Comentario Teste", 5, "2024-05-03", usuarioResponse, restauranteResponse);
        when(avaliacaoUseCase.buscarPorRestaurante(id)).thenReturn(Arrays.asList(avaliacaoResponse));

        ResponseEntity<List<AvaliacaoResponse>> response = avaliacaoController.buscarPorRestaurante(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());

    }


    @Test
    void salvar_deveRetornarAvaliacaoResponse_quandoAvaliacaoForSalva() {
        Long restauranteId = 1L;
        Long usuarioId = 1L;
        AvaliacaoRequest avaliacaoRequest = new AvaliacaoRequest(restauranteId, usuarioId, 4, "Comentario Teste", "2024-05-03");

        UsuarioResponse usuarioResponse = new UsuarioResponse(usuarioId, "Usuario", "usuario@email.com", "123456789", new ArrayList<>(), new ArrayList<>());
        List<MesaResponse> mesaResponses = new ArrayList<>();
        RestauranteResponse restauranteResponse = new RestauranteResponse(restauranteId, "Restaurante", "Localizacao", "Tipo", "Horarios", 10, mesaResponses);
        AvaliacaoResponse avaliacaoResponse = new AvaliacaoResponse(1L, "Comentario Teste", 4, "2024-05-03", usuarioResponse, restauranteResponse);


        when(avaliacaoUseCase.salvar(avaliacaoRequest)).thenReturn(avaliacaoResponse);

        ResponseEntity<AvaliacaoResponse> response = avaliacaoController.salvar(avaliacaoRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(avaliacaoResponse, response.getBody());
    }



}