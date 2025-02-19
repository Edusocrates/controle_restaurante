package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.apliacacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.RestauranteMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestauranteUseCaseTest {

    @InjectMocks
    private RestauranteUseCase restauranteUseCase;

    @Mock
    private RestauranteGateway restauranteGateway;

    @Mock
    private RestauranteMapper restauranteMapper;

    @Test
    void buscarTodos_DeveRetornarListaDeRestauranteResponse() {
        List<Restaurante> restaurantes = List.of(new Restaurante());
        List<RestauranteResponse> responses = List.of(new RestauranteResponse());

        when(restauranteGateway.findAll()).thenReturn(restaurantes);
        when(restauranteMapper.toResponse(any())).thenReturn(responses.get(0));

        List<RestauranteResponse> resultado = restauranteUseCase.buscarTodos();

        assertEquals(1, resultado.size());
        verify(restauranteGateway).findAll();
    }
    @Test
    void deveSalvarRestauranteComSucesso() {
        // Arrange
        RestauranteRequest request = new RestauranteRequest("Restaurante Teste", "Avenida XYZ, 123", "null", "null",123, Arrays.asList(new MesaRequest(1, 2, "teste", 1L, Arrays.asList(1L))));
        Restaurante restaurante = new Restaurante( );
        RestauranteResponse expectedResponse = new RestauranteResponse(1L, "Restaurante Teste", "Avenida XYZ, 123","teste", "teste", 123, Arrays.asList(new MesaResponse(1L, 2, 123,"teste", 1L, Arrays.asList(1L))));

        when(restauranteMapper.toEntity(request)).thenReturn(restaurante);
        when(restauranteGateway.save(restaurante)).thenReturn(restaurante);
        when(restauranteMapper.toResponse(restaurante)).thenReturn(expectedResponse);

        // Act
        RestauranteResponse response = restauranteUseCase.salvar(request);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNome()).isEqualTo("Restaurante Teste");

        verify(restauranteMapper, times(1)).toEntity(request);
        verify(restauranteGateway, times(1)).save(restaurante);
        verify(restauranteMapper, times(1)).toResponse(restaurante);
    }

    @Test
    void deveBuscarRestaurantePorIdComSucesso() {
        // Arrange
        Long restauranteId = 1L;
        Restaurante restaurante = new Restaurante();
        RestauranteResponse expectedResponse = new RestauranteResponse(1L, "Restaurante Teste", "Avenida XYZ, 123","teste", "teste", 123, Arrays.asList(new MesaResponse(1L, 2, 123,"teste", 1L, Arrays.asList(1L))));

        when(restauranteGateway.findById(restauranteId)).thenReturn(restaurante);
        when(restauranteMapper.toResponse(restaurante)).thenReturn(expectedResponse);

        // Act
        RestauranteResponse response = restauranteUseCase.buscarPorId(restauranteId);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(restauranteId);
        assertThat(response.getNome()).isEqualTo("Restaurante Teste");

        verify(restauranteGateway, times(1)).findById(restauranteId);
        verify(restauranteMapper, times(1)).toResponse(restaurante);
    }

}
