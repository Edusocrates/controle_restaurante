package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;

import java.util.List;

public interface MesaGateway {

    List<Mesa> findByRestauranteId(Long restauranteId);
    List<Mesa> findByStatus(String status);
    Mesa save(Mesa mesa);
    Mesa findById(Long id);
}
