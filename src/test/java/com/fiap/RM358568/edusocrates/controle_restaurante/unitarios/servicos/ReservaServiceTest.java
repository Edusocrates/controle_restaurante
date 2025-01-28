package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.ReservaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.ReservaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.ReservaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ReservaServiceTest {

    @InjectMocks
    private ReservaService reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private MesaRepository mesaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    private Reserva reserva;
    private ReservaDTO reservaDTO;
    private Restaurante restaurante;
    private Mesa mesa;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        restaurante = new Restaurante(1L, "Restaurante A", "Localização A", "Italiana", "9h-22h", 50, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        mesa = new Mesa(1L, 1, 4, "Disponível", restaurante, Collections.emptyList());
        usuario = new Usuario(1L, "João", "joao@email.com", "123456789", Collections.emptyList(), Collections.emptyList());

        reserva = new Reserva(1L, "2025-01-01", "20:00", 4, "Confirmada", restaurante, mesa, usuario);
        reservaDTO = new ReservaDTO(1L, "2025-01-01", "20:00", 4, "Confirmada", 1L, 1L, 1L);
    }

    @Test
    void testSalvar() {
        when(restauranteRepository.findById(1L)).thenReturn(Optional.of(restaurante));
        when(mesaRepository.findById(1L)).thenReturn(Optional.of(mesa));
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        ReservaDTO resultado = reservaService.salvar(reservaDTO);
        assertNotNull(resultado);
        assertEquals(reservaDTO.getNumeroDePessoas(), resultado.getNumeroDePessoas());
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }
}

