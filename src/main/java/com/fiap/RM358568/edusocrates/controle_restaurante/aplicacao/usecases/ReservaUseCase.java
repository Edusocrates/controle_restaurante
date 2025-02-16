package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import java.util.List;


public interface ReservaUseCase {


     List<ReservaDTO> buscarPorRestaurante(Long restauranteId);

     ReservaDTO salvar(ReservaDTO dto);
}
