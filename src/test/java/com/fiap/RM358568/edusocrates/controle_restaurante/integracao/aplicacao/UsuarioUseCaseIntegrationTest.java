package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.aplicacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.UsuarioUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.UsuarioMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioUseCaseIntegrationTest {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Test
    void buscarPorId_deveRetornarUsuarioResponse() {
        Long usuarioId = 1L;
        Usuario usuario = new Usuario();
        UsuarioResponse response = new UsuarioResponse();

        when(usuarioGateway.findById(usuarioId)).thenReturn(usuario);
        when(usuarioMapper.toResponse(usuario)).thenReturn(response);

        UsuarioResponse resultado = usuarioUseCase.buscarPorId(usuarioId);

        assertNotNull(resultado);
        verify(usuarioGateway).findById(usuarioId);
    }

    @Test
    void salvar_deveCriarNovoUsuario() {
        Usuario usuario = new Usuario();
        UsuarioResponse response = new UsuarioResponse();
        UsuarioRequest request = new UsuarioRequest("Nome Teste", "email@teste.com", "123456789", List.of(1L), List.of(2L));

        when(usuarioMapper.toEntity(request)).thenReturn(usuario);
        when(usuarioGateway.save(usuario)).thenReturn(usuario);
        when(usuarioMapper.toResponse(usuario)).thenReturn(response);

        UsuarioResponse resultado = usuarioUseCase.salvar(request);

        assertNotNull(resultado);
        verify(usuarioMapper).toEntity(request);
        verify(usuarioGateway).save(usuario);
        verify(usuarioMapper).toResponse(usuario);
    }
}