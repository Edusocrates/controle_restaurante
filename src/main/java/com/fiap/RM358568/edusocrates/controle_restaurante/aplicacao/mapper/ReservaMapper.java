package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaRequest reservaRequest, Restaurante restaurante, Mesa mesa, Usuario usuario) {
        Reserva reserva = new Reserva();
        reserva.setData(reservaRequest.data());
        reserva.setHorario(reservaRequest.horario());
        reserva.setNumeroDePessoas(reservaRequest.numeroDePessoas());
        reserva.setStatus(reservaRequest.status());
        reserva.setRestaurante(restaurante);
        reserva.setMesa(mesa);
        reserva.setUsuario(usuario);
        return reserva;
    }

    public ReservaResponse toResponse(Reserva reserva) {
        return new ReservaResponse(
                reserva.getId(),
                reserva.getData(),
                reserva.getHorario(),
                reserva.getNumeroDePessoas(),
                reserva.getStatus(),
                reserva.getRestaurante().getId(),
                reserva.getMesa().getId(),
                reserva.getUsuario().getId()
        );
    }
}
