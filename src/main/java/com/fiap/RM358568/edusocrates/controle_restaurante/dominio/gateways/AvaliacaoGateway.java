package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoGateway {
    List<Avaliacao> findByRestauranteId(Long restauranteId);
    Avaliacao save(Avaliacao avaliacao);
    Optional<Avaliacao> findById(Long id);
}
