package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MesaMapper {

    public Mesa toEntity(MesaRequest mesaRequest, Restaurante restaurante) {
        Mesa mesa = new Mesa();
        mesa.setNumero(mesaRequest.numero());
        mesa.setCapacidade(mesaRequest.capacidade());
        mesa.setStatus(mesaRequest.status());
        mesa.setRestaurante(restaurante);
        return mesa;
    }

    public MesaResponse toResponse(Mesa mesa) {
        return new MesaResponse(
                mesa.getId(),
                mesa.getNumero(),
                mesa.getCapacidade(),
                mesa.getStatus(),
                mesa.getRestaurante().getId(),
                mesa.getReservas().stream().map(reserva -> reserva.getId()).toList()
        );
    }
    public List<MesaResponse> toResponseList(List<Mesa> mesas) {
        return mesas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}