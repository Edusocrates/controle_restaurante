package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MesaUseCase {


    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private MesaMapper mesaMapper;

    public List<MesaResponse> buscarPorRestaurante(Long restauranteId) {
        return mesaRepository.findByRestauranteId(restauranteId).stream().map(mesaMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public MesaResponse salvar(MesaRequest mesaRequest) {
        Restaurante restaurante = restauranteRepository.findById(mesaRequest.restauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));

        Mesa mesa = mesaMapper.toEntity(mesaRequest, restaurante);
        mesa = mesaRepository.save(mesa);
        return mesaMapper.toResponse(mesa);
    }
}

