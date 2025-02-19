package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.ReservaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.ReservaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ReservaRepositoryGateway implements ReservaGateway {
    private final ReservaRepository reservaRepository;

    public ReservaRepositoryGateway(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> findByRestauranteId(Long restauranteId) {
        return reservaRepository.findByRestauranteId(restauranteId);
    }

    @Override
    public List<Reserva> findByUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Reserva> findByDataAndHorarioAndMesaId(String data, String horario, Long mesaId) {
        return reservaRepository.findByDataAndHorarioAndMesaId(data, horario, mesaId);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

}
