package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.UsuarioMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.UsuarioService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.UsuarioDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario(1L, "João", "joao@email.com", "123456789", Collections.emptyList(), Collections.emptyList());
        usuarioDTO = new UsuarioDTO(1L, "João", "joao@email.com", "123456789", Collections.emptyList(), Collections.emptyList());
    }

    @Test
    void testBuscarPorId() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        UsuarioDTO resultado = usuarioService.buscarPorId(1L);
        assertNotNull(resultado);
        assertEquals(usuarioDTO.getNome(), resultado.getNome());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testSalvar() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        UsuarioDTO resultado = usuarioService.salvar(usuarioDTO);
        assertNotNull(resultado);
        assertEquals(usuarioDTO.getNome(), resultado.getNome());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
}
