package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    @Autowired
    private MesaMapper mesaMapper;


    public Restaurante toEntity(RestauranteRequest restauranteRequest) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteRequest.nome());
        restaurante.setLocalizacao(restauranteRequest.localizacao());
        restaurante.setTipoDeCozinha(restauranteRequest.tipoDeCozinha());
        restaurante.setHorariosFuncionamento(restauranteRequest.horariosFuncionamento());
        restaurante.setCapacidade(restauranteRequest.capacidade());
        return restaurante;
    }

    public RestauranteResponse toResponse(Restaurante restaurante) {
        return new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getLocalizacao(),
                restaurante.getTipoDeCozinha(),
                restaurante.getHorariosFuncionamento(),
                restaurante.getCapacidade(),
                mesaMapper.toResponseList(restaurante.getMesas())
        );
    }
}
