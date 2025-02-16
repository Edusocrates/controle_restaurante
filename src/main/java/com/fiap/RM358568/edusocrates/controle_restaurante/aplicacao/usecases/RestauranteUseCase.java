package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;


import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import java.util.List;

public interface RestauranteUseCase {



     List<RestauranteDTO> buscarTodos();

     RestauranteDTO buscarPorId(Long id);

     RestauranteDTO salvar(RestauranteDTO dto);
}

