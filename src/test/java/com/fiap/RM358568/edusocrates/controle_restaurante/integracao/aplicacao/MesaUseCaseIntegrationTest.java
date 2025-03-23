package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.aplicacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.MesaUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways.MesaRepositoryGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways.RestauranteRepositoryGateway;
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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MesaUseCaseIntegrationTest {

    @InjectMocks
    private MesaUseCase mesaUseCase;

    @Mock
    private MesaRepositoryGateway mesaRepositoryGateway;

    @Mock
    private RestauranteRepositoryGateway restauranteRepositoryGateway;

    @Mock
    private MesaMapper mesaMapper;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeMesas() {
        Long restauranteId = 1L;
        Mesa mesa = new Mesa();
        MesaResponse response = new MesaResponse();

        when(mesaRepositoryGateway.findByRestauranteId(restauranteId)).thenReturn(Collections.singletonList(mesa));
        when(mesaMapper.toResponse(mesa)).thenReturn(response);

        List<MesaResponse> resultado = mesaUseCase.buscarPorRestaurante(restauranteId);

        assertNotNull(resultado);
        verify(mesaRepositoryGateway).findByRestauranteId(restauranteId);
    }

    @Test
    void salvar_deveCriarNovaMesa() {
        MesaRequest request = new MesaRequest(1, 4, "teste", 1L, List.of(1L));
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa();
        MesaResponse response = new MesaResponse();

        when(restauranteRepositoryGateway.findById(any())).thenReturn(restaurante);
        when(mesaMapper.toEntity(any(), any())).thenReturn(mesa);
        when(mesaRepositoryGateway.save(any())).thenReturn(mesa);
        when(mesaMapper.toResponse(any())).thenReturn(response);

        MesaResponse resultado = mesaUseCase.salvar(request);

        assertNotNull(resultado);
        verify(mesaRepositoryGateway).save(mesa);
    }
}