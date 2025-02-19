package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways.MesaRepositoryGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways.RestauranteRepositoryGateway;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MesaUseCase {


    @Autowired
    private MesaRepositoryGateway mesaRepositoryGateway;

    @Autowired
    private RestauranteRepositoryGateway restauranteRepositoryGateway;

    @Autowired
    private MesaMapper mesaMapper;

    public List<MesaResponse> buscarPorRestaurante(Long restauranteId) {
        return mesaRepositoryGateway.findByRestauranteId(restauranteId).stream().map(mesaMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public MesaResponse salvar(MesaRequest mesaRequest) {
        Restaurante restaurante = restauranteRepositoryGateway.findById(mesaRequest.restauranteId());

        Mesa mesa = mesaMapper.toEntity(mesaRequest, restaurante);
        mesa = mesaRepositoryGateway.save(mesa);
        return mesaMapper.toResponse(mesa);
    }
}

