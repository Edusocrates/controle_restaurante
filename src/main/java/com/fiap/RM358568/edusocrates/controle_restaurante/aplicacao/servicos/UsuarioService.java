package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.UsuarioMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.UsuarioDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return usuarioMapper.toDTO(usuario);
    }

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }
}
