package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.MesaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MesaUseCase {


    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private MesaMapper mesaMapper;

    public List<MesaDTO> buscarPorRestaurante(Long restauranteId) {
        return mesaRepository.findByRestauranteId(restauranteId).stream().map(mesaMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public MesaDTO salvar(MesaDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));

        Mesa mesa = mesaMapper.toEntity(dto, restaurante);
        mesa = mesaRepository.save(mesa);
        return mesaMapper.toDTO(mesa);
    }
}

