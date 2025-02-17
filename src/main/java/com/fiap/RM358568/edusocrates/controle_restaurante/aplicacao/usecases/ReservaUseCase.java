package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.ReservaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.ReservaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ReservaUseCase {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaResponse> buscarPorRestaurante(Long restauranteId) {
        return reservaRepository.findByRestauranteId(restauranteId).stream().map(reservaMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public ReservaResponse salvar(ReservaRequest reservaRequest) {
        Restaurante restaurante = restauranteRepository.findById(reservaRequest.restauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));
        Usuario usuario = usuarioRepository.findById(reservaRequest.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        Mesa mesa = mesaRepository.findById(reservaRequest.mesaId()).orElseThrow(() -> new RuntimeException("Mesa não encontrada."));

        Reserva reserva = reservaMapper.toEntity(reservaRequest, restaurante, mesa, usuario);
        reserva = reservaRepository.save(reserva);
        return reservaMapper.toResponse(reserva);
    }
}
