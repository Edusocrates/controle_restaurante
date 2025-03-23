package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.aplicacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.ReservaUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.MesaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.ReservaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.ReservaMapper;
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
class ReservaUseCaseIntegrationTest {

    @InjectMocks
    private ReservaUseCase reservaUseCase;

    @Mock
    private ReservaGateway reservaGateway;

    @Mock
    private RestauranteGateway restauranteGateway;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private MesaGateway mesaGateway;

    @Mock
    private ReservaMapper reservaMapper;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeReservas() {
        Long restauranteId = 1L;
        Reserva reserva = new Reserva();
        ReservaResponse response = new ReservaResponse();

        when(reservaGateway.findByRestauranteId(restauranteId)).thenReturn(Collections.singletonList(reserva));
        when(reservaMapper.toResponse(reserva)).thenReturn(response);

        List<ReservaResponse> resultado = reservaUseCase.buscarPorRestaurante(restauranteId);

        assertNotNull(resultado);
        verify(reservaGateway).findByRestauranteId(restauranteId);
    }

    @Test
    void salvar_deveCriarNovaReserva() {
        ReservaRequest request = new ReservaRequest(1L, 1L, 1L, "2025-02-01 19:00", "2025-02-01 21:00", 2, "");
        Restaurante restaurante = new Restaurante();
        Usuario usuario = new Usuario();
        Mesa mesa = new Mesa();
        Reserva reserva = new Reserva();
        ReservaResponse response = new ReservaResponse();

        when(restauranteGateway.findById(any())).thenReturn(restaurante);
        when(usuarioGateway.findById(any())).thenReturn(usuario);
        when(mesaGateway.findById(any())).thenReturn(mesa);
        when(reservaMapper.toEntity(any(), any(), any(), any())).thenReturn(reserva);
        when(reservaGateway.save(any())).thenReturn(reserva);
        when(reservaMapper.toResponse(any())).thenReturn(response);

        ReservaResponse resultado = reservaUseCase.salvar(request);

        assertNotNull(resultado);
        verify(reservaGateway).save(reserva);
    }
}