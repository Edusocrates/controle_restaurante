package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.ReservaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.MesaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.ReservaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservaUseCase {

    @Autowired
    private ReservaGateway reservaGateway;

    @Autowired
    private RestauranteGateway restauranteGateway;

    @Autowired
    private UsuarioGateway usuarioGateway;

    @Autowired
    private MesaGateway mesaGateway;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaResponse> buscarPorRestaurante(Long restauranteId) {
        return reservaGateway.findByRestauranteId(restauranteId).stream().map(reservaMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public ReservaResponse salvar(ReservaRequest reservaRequest) {
        Restaurante restaurante = restauranteGateway.findById(reservaRequest.restauranteId());
        Usuario usuario = usuarioGateway.findById(reservaRequest.usuarioId());
        Mesa mesa = mesaGateway.findById(reservaRequest.mesaId());

        Reserva reserva = reservaMapper.toEntity(reservaRequest, restaurante, mesa, usuario);
        reserva = reservaGateway.save(reserva);
        return reservaMapper.toResponse(reserva);
    }
}
