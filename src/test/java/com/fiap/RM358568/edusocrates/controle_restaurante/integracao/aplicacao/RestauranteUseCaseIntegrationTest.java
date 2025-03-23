package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.aplicacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.RestauranteMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RestauranteUseCaseIntegrationTest {

    @InjectMocks
    private RestauranteUseCase restauranteUseCase;

    @Mock
    private RestauranteGateway restauranteGateway;

    @Mock
    private RestauranteMapper restauranteMapper;

    @Test
    void buscarTodos_deveRetornarListaDeRestaurantes() {
        Restaurante restaurante = new Restaurante();
        RestauranteResponse response = new RestauranteResponse();

        when(restauranteGateway.findAll()).thenReturn(Collections.singletonList(restaurante));
        when(restauranteMapper.toResponse(restaurante)).thenReturn(response);

        List<RestauranteResponse> resultado = restauranteUseCase.buscarTodos();

        assertNotNull(resultado);
        verify(restauranteGateway).findAll();
    }

    @Test
    void buscarPorId_deveRetornarRestauranteResponse() {
        Long restauranteId = 1L;
        Restaurante restaurante = new Restaurante();
        RestauranteResponse response = new RestauranteResponse();

        when(restauranteGateway.findById(restauranteId)).thenReturn(restaurante);
        when(restauranteMapper.toResponse(restaurante)).thenReturn(response);

        RestauranteResponse resultado = restauranteUseCase.buscarPorId(restauranteId);

        assertNotNull(resultado);
        verify(restauranteGateway).findById(restauranteId);
    }

    @Test
    void salvar_deveCriarNovoRestaurante() {
        Restaurante restaurante = new Restaurante();
        RestauranteResponse response = new RestauranteResponse();
        RestauranteRequest request = new RestauranteRequest("Nome Teste", "Endereço Teste", "123456789", "Tipo Teste", 50, Collections.emptyList());

        when(restauranteMapper.toEntity(request)).thenReturn(restaurante);
        when(restauranteGateway.save(restaurante)).thenReturn(restaurante);
        when(restauranteMapper.toResponse(restaurante)).thenReturn(response);

        RestauranteResponse resultado = restauranteUseCase.salvar(request);

        assertNotNull(resultado);
        verify(restauranteMapper).toEntity(request);
        verify(restauranteGateway).save(restaurante);
        verify(restauranteMapper).toResponse(restaurante);
    }
}