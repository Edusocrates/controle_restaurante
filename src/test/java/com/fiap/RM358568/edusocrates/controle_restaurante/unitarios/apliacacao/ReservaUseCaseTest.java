package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.apliacacao;

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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservaUseCaseTest {

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
    void buscarPorRestaurante_DeveRetornarListaDeReservaResponse() {
        Long restauranteId = 1L;
        List<Reserva> reservas = List.of(new Reserva());
        List<ReservaResponse> responses = List.of(new ReservaResponse());

        when(reservaGateway.findByRestauranteId(restauranteId)).thenReturn(reservas);
        when(reservaMapper.toResponse(any())).thenReturn(responses.get(0));

        List<ReservaResponse> resultado = reservaUseCase.buscarPorRestaurante(restauranteId);

        assertEquals(1, resultado.size());
        verify(reservaGateway).findByRestauranteId(restauranteId);
    }

    @Test
    void salvar_DeveSalvarReservaERetornarResponse() {
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

