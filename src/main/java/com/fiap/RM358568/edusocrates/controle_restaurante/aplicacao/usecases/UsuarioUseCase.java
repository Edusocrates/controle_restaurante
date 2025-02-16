package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.UsuarioDTO;

public interface UsuarioUseCase {

     UsuarioDTO buscarPorId(Long id);

     UsuarioDTO salvar(UsuarioDTO dto);
}

