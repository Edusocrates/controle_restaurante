package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByRestauranteId(Long restauranteId);
    List<Mesa> findByStatus(String status);
}
