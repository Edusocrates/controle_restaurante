package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public RestauranteDTO toDTO(Restaurante restaurante) {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setLocalizacao(restaurante.getLocalizacao());
        dto.setTipoDeCozinha(restaurante.getTipoDeCozinha());
        dto.setHorariosFuncionamento(restaurante.getHorariosFuncionamento());
        dto.setCapacidade(restaurante.getCapacidade());
        return dto;
    }

    public Restaurante toEntity(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setLocalizacao(dto.getLocalizacao());
        restaurante.setTipoDeCozinha(dto.getTipoDeCozinha());
        restaurante.setHorariosFuncionamento(dto.getHorariosFuncionamento());
        restaurante.setCapacidade(dto.getCapacidade());
        return restaurante;
    }
}
