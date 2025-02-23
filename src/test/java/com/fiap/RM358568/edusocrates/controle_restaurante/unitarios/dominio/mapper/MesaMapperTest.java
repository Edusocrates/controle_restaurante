package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.dominio.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.MesaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MesaMapperTest {

    @InjectMocks
    private MesaMapper mesaMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveConverterMesaRequestParaEntity() {
        // Arrange
        MesaRequest request = new MesaRequest(10, 4, "Disponível", 1L,new ArrayList<>());
        Restaurante restaurante = new Restaurante(1L, "Restaurante Teste", "Endereço X", "teste", "teste", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Act
        Mesa mesa = mesaMapper.toEntity(request, restaurante);

        // Assert
        assertThat(mesa).isNotNull();
        assertThat(mesa.getNumero()).isEqualTo(10);
        assertThat(mesa.getCapacidade()).isEqualTo(4);
        assertThat(mesa.getStatus()).isEqualTo("Disponível");
        assertThat(mesa.getRestaurante()).isEqualTo(restaurante);
    }

    @Test
    void deveConverterMesaParaResponse() {
        // Arrange
        Mesa mesa = new Mesa(1L, 10, 4, "Disponível", new Restaurante(), List.of(new Reserva(), new Reserva()));

        // Act
        MesaResponse response = mesaMapper.toResponse(mesa);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNumero()).isEqualTo(10);
        assertThat(response.getCapacidade()).isEqualTo(4);

    }


    @Test
    void testToResponseList() {
        Mesa mesa1 = new Mesa();
        Restaurante restaurante = new Restaurante(1L, "Restaurante Teste", "Endereço X", "teste", "teste", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        mesa1.setId(1L);
        mesa1.setNumero(10);
        mesa1.setCapacidade(4);
        mesa1.setStatus("Disponível");
        mesa1.setReservas(List.of(new Reserva(), new Reserva()));
        mesa1.setRestaurante(restaurante);

        Mesa mesa2 = new Mesa();
        mesa2.setId(2L);
        mesa2.setNumero(20);
        mesa2.setCapacidade(6);
        mesa2.setStatus("Ocupado");
        mesa2.setReservas(List.of(new Reserva(), new Reserva()));
        mesa2.setRestaurante(restaurante);

        List<Mesa> mesas = Arrays.asList(mesa1, mesa2);
        List<MesaResponse> mesaResponses = mesaMapper.toResponseList(mesas);

        assertNotNull(mesaResponses);
        assertEquals(2, mesaResponses.size());
        assertEquals(mesa1.getId(), mesaResponses.get(0).getId());
        assertEquals(mesa2.getId(), mesaResponses.get(1).getId());
        assertEquals(mesa1.getNumero(), mesaResponses.get(0).getNumero());
        assertEquals(mesa2.getNumero(), mesaResponses.get(1).getNumero());
    }
}