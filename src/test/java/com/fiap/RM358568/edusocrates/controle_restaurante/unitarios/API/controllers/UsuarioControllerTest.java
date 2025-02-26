package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.usuario.UsuarioController;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.UsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioUseCase usuarioUseCase;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void buscarPorId_deveRetornarUsuarioResponse_quandoUsuarioExistir() {
        Long id = 1L;
        UsuarioResponse usuarioResponse = new UsuarioResponse(id, "Nome Teste", "email@teste.com", "123456789", new ArrayList<>(), new ArrayList<>());
        when(usuarioUseCase.buscarPorId(id)).thenReturn(usuarioResponse);

        ResponseEntity<UsuarioResponse> response = usuarioController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioResponse, response.getBody());
    }

    @Test
    void salvar_deveRetornarUsuarioResponse_quandoUsuarioForSalvo() {
        List<Long> reservasIds = new ArrayList<>();
        reservasIds.add(1L);
        List<Long> avaliacoesIds = new ArrayList<>();
        avaliacoesIds.add(2L);

        UsuarioRequest usuarioRequest = new UsuarioRequest("Nome Teste", "email@teste.com", "123456789", reservasIds, avaliacoesIds);
        UsuarioResponse usuarioResponse = new UsuarioResponse(1L, "Nome Teste", "email@teste.com", "123456789", reservasIds, avaliacoesIds);

        when(usuarioUseCase.salvar(usuarioRequest)).thenReturn(usuarioResponse);

        ResponseEntity<UsuarioResponse> response = usuarioController.salvar(usuarioRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioResponse, response.getBody());
    }


}


