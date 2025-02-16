package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import java.util.List;

public interface MesaUseCase {


     List<MesaDTO> buscarPorRestaurante(Long restauranteId);


     MesaDTO salvar(MesaDTO dto);
}

