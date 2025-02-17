package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByRestauranteId(Long restauranteId);
    List<Avaliacao> findByUsuarioId(Long usuarioId);
}