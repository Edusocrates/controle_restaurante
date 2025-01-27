package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setData(reserva.getData());
        dto.setHorario(reserva.getHorario());
        dto.setNumeroDePessoas(reserva.getNumeroDePessoas());
        dto.setStatus(reserva.getStatus());
        dto.setRestauranteId(reserva.getRestaurante().getId());
        dto.setMesaId(reserva.getMesa().getId());
        dto.setUsuarioId(reserva.getUsuario().getId());
        return dto;
    }

    public Reserva toEntity(ReservaDTO dto, Restaurante restaurante, Mesa mesa, Usuario usuario) {
        Reserva reserva = new Reserva();
        reserva.setData(dto.getData());
        reserva.setHorario(dto.getHorario());
        reserva.setNumeroDePessoas(dto.getNumeroDePessoas());
        reserva.setStatus(dto.getStatus());
        reserva.setRestaurante(restaurante);
        reserva.setMesa(mesa);
        reserva.setUsuario(usuario);
        return reserva;
    }
}
