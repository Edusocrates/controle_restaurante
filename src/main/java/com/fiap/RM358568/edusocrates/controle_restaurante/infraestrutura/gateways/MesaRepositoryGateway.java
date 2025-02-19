package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.MesaGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MesaRepositoryGateway implements MesaGateway {

    private final MesaRepository mesaRepository;

    public MesaRepositoryGateway(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Override
    public List<Mesa> findByRestauranteId(Long restauranteId) {
        return List.of();
    }

    @Override
    public List<Mesa> findByStatus(String status) {
        return List.of();
    }

    @Override
    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa findById(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

}
