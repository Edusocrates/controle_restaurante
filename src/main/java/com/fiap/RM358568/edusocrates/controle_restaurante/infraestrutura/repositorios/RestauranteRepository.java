package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByNomeContainingIgnoreCase(String nome);
    List<Restaurante> findByLocalizacaoContainingIgnoreCase(String localizacao);
    List<Restaurante> findByTipoDeCozinhaContainingIgnoreCase(String tipoDeCozinha);
}
