package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;

import java.util.List;

public interface ReservaGateway {
    List<Reserva> findByRestauranteId(Long restauranteId);
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByDataAndHorarioAndMesaId(String data, String horario, Long mesaId);
    Reserva save(Reserva reserva);
}
