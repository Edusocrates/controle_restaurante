package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDTO toDTO(Mesa mesa) {
        MesaDTO dto = new MesaDTO();
        dto.setId(mesa.getId());
        dto.setNumero(mesa.getNumero());
        dto.setCapacidade(mesa.getCapacidade());
        dto.setStatus(mesa.getStatus());
        dto.setRestauranteId(mesa.getRestaurante().getId());
        return dto;
    }

    public Mesa toEntity(MesaDTO dto, Restaurante restaurante) {
        Mesa mesa = new Mesa();
        mesa.setNumero(dto.getNumero());
        mesa.setCapacidade(dto.getCapacidade());
        mesa.setStatus(dto.getStatus());
        mesa.setRestaurante(restaurante);
        return mesa;
    }
}