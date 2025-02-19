package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.RestauranteMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteUseCase {

    @Autowired
    private RestauranteGateway restauranteGateway;

    @Autowired
    private RestauranteMapper restauranteMapper;

    public List<RestauranteResponse> buscarTodos() {
        return restauranteGateway.findAll().stream().map(restauranteMapper::toResponse).collect(Collectors.toList());
    }

    public RestauranteResponse buscarPorId(Long id) {
        Restaurante restaurante = restauranteGateway.findById(id);
        return restauranteMapper.toResponse(restaurante);
    }

    @Transactional
    public RestauranteResponse salvar(RestauranteRequest restauranteRequest) {
        Restaurante restaurante = restauranteMapper.toEntity(restauranteRequest);
        restaurante = restauranteGateway.save(restaurante);
        return restauranteMapper.toResponse(restaurante);
    }
}

