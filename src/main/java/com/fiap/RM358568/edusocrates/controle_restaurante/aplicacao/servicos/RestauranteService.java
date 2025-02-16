package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.RestauranteMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService implements RestauranteUseCase {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @Override
    public List<RestauranteDTO> buscarTodos() {
        return restauranteRepository.findAll().stream().map(restauranteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public RestauranteDTO buscarPorId(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));
        return restauranteMapper.toDTO(restaurante);
    }

    @Transactional
    @Override
    public RestauranteDTO salvar(RestauranteDTO dto) {
        Restaurante restaurante = restauranteMapper.toEntity(dto);
        restaurante = restauranteRepository.save(restaurante);
        return restauranteMapper.toDTO(restaurante);
    }
}

