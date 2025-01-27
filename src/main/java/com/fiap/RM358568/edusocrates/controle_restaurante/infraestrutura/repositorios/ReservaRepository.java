package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByRestauranteId(Long restauranteId);
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByDataAndHorarioAndMesaId(String data, String horario, Long mesaId);
}
