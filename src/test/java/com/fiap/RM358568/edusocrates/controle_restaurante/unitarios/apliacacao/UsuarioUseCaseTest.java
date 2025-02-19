package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.apliacacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.UsuarioUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.UsuarioMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioUseCaseTest {

    @InjectMocks
    private UsuarioUseCase usuarioUseCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock
    private UsuarioRequest usuarioRequest1;

    @Mock
    private UsuarioResponse usuarioResponse;

    @Test
    void buscarPorId_DeveRetornarUsuarioResponse() {
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
    void salvar_DeveRetornarUsuarioResponseQuandoSalvoComSucesso() {
        // Arrange
        Usuario usuario = new Usuario();
        UsuarioResponse response = new UsuarioResponse();
        UsuarioRequest usuarioRequest = new UsuarioRequest("Eduardo", "teste","teste", Arrays.asList(1L, 2L), Arrays.asList(1L, 2L));

        when(usuarioMapper.toEntity(usuarioRequest)).thenReturn(usuario);
        when(usuarioGateway.save(usuario)).thenReturn(usuario);
        when(usuarioMapper.toResponse(usuario)).thenReturn(response);
        when(usuarioMapper.toEntity(usuarioRequest)).thenReturn(usuario);
        when(usuarioGateway.save(usuario)).thenReturn(usuario);
        when(usuarioMapper.toResponse(usuario)).thenReturn(response);

        // Act
        UsuarioResponse result = usuarioUseCase.salvar(usuarioRequest);

        // Assert
        assertNotNull(result);
        assertEquals(1, 1);

        // Verificando se as interações ocorreram
        verify(usuarioMapper).toEntity(usuarioRequest);
        verify(usuarioGateway).save(usuario);
        verify(usuarioMapper).toResponse(usuario);
    }
}

