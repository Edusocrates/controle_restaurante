package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.dominio.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.RestauranteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RestauranteMapperTest {

    @Mock
    private MesaMapper mesaMapper;

    @InjectMocks
    private RestauranteMapper restauranteMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveConverterRestauranteRequestParaEntity() {
        // Arrange
        RestauranteRequest request = new RestauranteRequest("Restaurante Teste", "Rua X, 123", "Italiana", "08:00 - 22:00", 50, new ArrayList<>());

        // Act
        Restaurante restaurante = restauranteMapper.toEntity(request);

        // Assert
        assertThat(restaurante).isNotNull();
        assertThat(restaurante.getNome()).isEqualTo("Restaurante Teste");
        assertThat(restaurante.getLocalizacao()).isEqualTo("Rua X, 123");
        assertThat(restaurante.getTipoDeCozinha()).isEqualTo("Italiana");
        assertThat(restaurante.getHorariosFuncionamento()).isEqualTo("08:00 - 22:00");
        assertThat(restaurante.getCapacidade()).isEqualTo(50);
    }

    @Test
    void deveConverterRestauranteParaResponse() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Teste", "Endereço X", "teste", "teste", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        List<MesaResponse> mesaResponses = List.of(new MesaResponse());

        when(mesaMapper.toResponseList(restaurante.getMesas())).thenReturn(mesaResponses);

        // Act
        RestauranteResponse response = restauranteMapper.toResponse(restaurante);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNome()).isEqualTo("Restaurante Teste");

    }
}
