package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.dominio.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.ReservaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReservaMapperTest {

    @InjectMocks
    private ReservaMapper reservaMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveConverterReservaRequestParaEntity() {
        // Arrange
        ReservaRequest request = new ReservaRequest(1L, 1L, 1L, LocalDate.now().toString(), LocalTime.of(19, 30).toString(), 4, "Confirmada");
        Restaurante restaurante = new Restaurante(1L, "Restaurante Teste", "Endereço X", "teste", "teste", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Mesa mesa = new Mesa(1L, 10, 4, "Disponível", new Restaurante(), List.of(new Reserva(), new Reserva()));
        Usuario usuario = new Usuario(2L, "Usuário Teste", "user@email.com", "teste", new ArrayList<>(),new ArrayList<>());

        // Act
        Reserva reserva = reservaMapper.toEntity(request, restaurante, mesa, usuario);

        // Assert
        assertThat(reserva).isNotNull();
        assertThat(reserva.getData()).isEqualTo(request.data());
        assertThat(reserva.getHorario()).isEqualTo(request.horario());
        assertThat(reserva.getNumeroDePessoas()).isEqualTo(4);
        assertThat(reserva.getStatus()).isEqualTo("Confirmada");
        assertThat(reserva.getRestaurante()).isEqualTo(restaurante);
        assertThat(reserva.getMesa()).isEqualTo(mesa);
        assertThat(reserva.getUsuario()).isEqualTo(usuario);
    }

    @Test
    void deveConverterReservaParaResponse() {
        // Arrange
        Reserva reserva = new Reserva(1L, LocalDate.now().toString(), LocalTime.of(19, 30).toString(), 4, "Confirmada", new Restaurante(), new Mesa(), new Usuario());

        // Act
        ReservaResponse response = reservaMapper.toResponse(reserva);

        // Assert
        assertThat(response).isNotNull();
    }
}

