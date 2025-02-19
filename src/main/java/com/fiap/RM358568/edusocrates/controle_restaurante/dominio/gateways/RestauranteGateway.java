package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;

import java.util.List;

public interface RestauranteGateway {

    List<Restaurante> findByNomeContainingIgnoreCase(String nome);
    List<Restaurante> findByLocalizacaoContainingIgnoreCase(String localizacao);
    List<Restaurante> findByTipoDeCozinhaContainingIgnoreCase(String tipoDeCozinha);
    List<Restaurante> findAll();
    Restaurante save(Restaurante restaurante);
    Restaurante findById(Long id);
}
