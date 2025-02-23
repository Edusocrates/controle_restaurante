package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.dominio.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.AvaliacaoMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.RestauranteMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.UsuarioMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AvaliacaoMapperTest {

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock
    private RestauranteMapper restauranteMapper;

    @InjectMocks
    private AvaliacaoMapper avaliacaoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveConverterAvaliacaoRequestParaEntity() {
        // Arrange
        AvaliacaoRequest request = new AvaliacaoRequest(5L, 1L, 2, "Ótimo!", "2L");
        Restaurante restaurante = new Restaurante(1L, "Restaurante Teste", "Endereço X", "teste", "teste", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Usuario usuario = new Usuario(2L, "Usuário Teste", "user@email.com", "teste", new ArrayList<>(),new ArrayList<>());

        // Act
        Avaliacao avaliacao = avaliacaoMapper.toEntity(request, restaurante, usuario);

        // Assert
        assertThat(avaliacao).isNotNull();
        assertThat(avaliacao.getNota()).isEqualTo(2);
        assertThat(avaliacao.getComentario()).isEqualTo("Ótimo!");
        assertThat(avaliacao.getRestaurante()).isEqualTo(restaurante);
        assertThat(avaliacao.getUsuario()).isEqualTo(usuario);
    }

    @Test
    void deveConverterAvaliacaoParaResponse() {
        // Arrange
        Avaliacao avaliacao = new Avaliacao(1L, 5, "Ótimo!", LocalDate.now().toString(), new Restaurante(), new Usuario());
        UsuarioResponse usuarioResponse = new UsuarioResponse(2L, "Usuário Teste", "user@email.com", "teste", new ArrayList<>(),new ArrayList<>());
        RestauranteResponse restauranteResponse = new RestauranteResponse(1L, "Restaurante Teste", "Endereço X","teste","teste", 1, new ArrayList<>());

        when(usuarioMapper.toResponse(any())).thenReturn(usuarioResponse);
        when(restauranteMapper.toResponse(any())).thenReturn(restauranteResponse);

        // Act
        AvaliacaoResponse response = avaliacaoMapper.toResponse(avaliacao);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNota()).isEqualTo(5);
        assertThat(response.getUsuario()).isEqualTo(usuarioResponse);
        assertThat(response.getRestaurante()).isEqualTo(restauranteResponse);
    }
}