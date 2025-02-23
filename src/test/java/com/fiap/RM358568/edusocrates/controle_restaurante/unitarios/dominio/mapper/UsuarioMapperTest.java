package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.dominio.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.UsuarioMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


class UsuarioMapperTest {

    private UsuarioMapper usuarioMapper;

    @BeforeEach
    void setUp() {
        usuarioMapper = new UsuarioMapper();
    }

    @Test
    void testToEntity() {
        UsuarioRequest request = new UsuarioRequest("João Silva", "joao@email.com", "123456789", new ArrayList<>(), new ArrayList<>());

        Usuario usuario = usuarioMapper.toEntity(request);

        assertNotNull(usuario);
        assertEquals("João Silva", usuario.getNome());
        assertEquals("joao@email.com", usuario.getEmail());
        assertEquals("123456789", usuario.getTelefone());
    }

    @Test
    void testToResponse() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Maria Souza");
        usuario.setEmail("maria@email.com");
        usuario.setTelefone("987654321");
        usuario.setAvaliacoes(Collections.emptyList());
        usuario.setReservas(Collections.emptyList());

        UsuarioResponse response = usuarioMapper.toResponse(usuario);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Maria Souza", response.getNome());
        assertEquals("maria@email.com", response.getEmail());
        assertEquals("987654321", response.getTelefone());
        assertTrue(response.getAvaliacoesIds().isEmpty());
        assertTrue(response.getReservasIds().isEmpty());
    }
}

