package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.MesaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MesaServiceTest {

    @InjectMocks
    private MesaService mesaService;

    @Mock
    private MesaRepository mesaRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    private Mesa mesa;
    private MesaDTO mesaDTO;
    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        restaurante = new Restaurante(1L, "Restaurante A", "Localização A", "Italiana", "9h-22h", 50, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        mesa = new Mesa(1L, 1, 4, "Disponível", restaurante, Collections.emptyList());
        mesaDTO = new MesaDTO(1L, 1, 4, "Disponível", 1L, Collections.emptyList());
    }

    @Test
    void testSalvar() {
        when(restauranteRepository.findById(1L)).thenReturn(Optional.of(restaurante));
        when(mesaRepository.save(any(Mesa.class))).thenReturn(mesa);

        MesaDTO resultado = mesaService.salvar(mesaDTO);
        assertNotNull(resultado);
        assertEquals(mesaDTO.getNumero(), resultado.getNumero());
        verify(mesaRepository, times(1)).save(any(Mesa.class));
    }
}
