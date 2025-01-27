package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setId(avaliacao.getId());
        dto.setNota(avaliacao.getNota());
        dto.setComentario(avaliacao.getComentario());
        dto.setData(avaliacao.getData());
        dto.setRestauranteId(avaliacao.getRestaurante().getId());
        dto.setUsuarioId(avaliacao.getUsuario().getId());
        return dto;
    }

    public Avaliacao toEntity(AvaliacaoDTO dto, Restaurante restaurante, Usuario usuario) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setData(dto.getData());
        avaliacao.setRestaurante(restaurante);
        avaliacao.setUsuario(usuario);
        return avaliacao;
    }
}

