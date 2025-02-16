package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import java.util.List;


public interface AvaliacaoUseCase {

     List<AvaliacaoDTO> buscarPorRestaurante(Long restauranteId);

     AvaliacaoDTO salvar(AvaliacaoDTO dto);
}
