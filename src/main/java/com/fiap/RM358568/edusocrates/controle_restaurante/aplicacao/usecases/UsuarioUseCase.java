package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.UsuarioMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UsuarioUseCase {


    @Autowired
    private UsuarioGateway usuarioGateway;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioGateway.findById(id);
        return usuarioMapper.toResponse(usuario);
    }

    @Transactional
    public UsuarioResponse salvar(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);
        usuario = usuarioGateway.save(usuario);
        return usuarioMapper.toResponse(usuario);
    }
}

