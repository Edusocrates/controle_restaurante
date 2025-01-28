package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.AvaliacaoMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.AvaliacaoService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.AvaliacaoRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AvaliacaoServiceTest {

    @InjectMocks
    private AvaliacaoService avaliacaoService;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    private Avaliacao avaliacao;
    private AvaliacaoDTO avaliacaoDTO;
    private Restaurante restaurante;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        restaurante = new Restaurante(1L, "Restaurante A", "Localização A", "Italiana", "9h-22h", 50, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        usuario = new Usuario(1L, "João", "joao@email.com", "123456789", Collections.emptyList(), Collections.emptyList());

        avaliacao = new Avaliacao(1L, 5, "Ótimo restaurante!", "2025-01-01", restaurante, usuario);
        avaliacaoDTO = new AvaliacaoDTO(1L, 5, "Ótimo restaurante!", "2025-01-01", 1L, 1L);
    }

    @Test
    void testSalvar() {
        when(restauranteRepository.findById(1L)).thenReturn(Optional.of(restaurante));
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(avaliacaoRepository.save(any(Avaliacao.class))).thenReturn(avaliacao);

        AvaliacaoDTO resultado = avaliacaoService.salvar(avaliacaoDTO);
        assertNotNull(resultado);
        assertEquals(avaliacaoDTO.getNota(), resultado.getNota());
        verify(avaliacaoRepository, times(1)).save(any(Avaliacao.class));
    }
}