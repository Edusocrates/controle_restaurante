package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private RestauranteMapper restauranteMapper;


    public Avaliacao toEntity(AvaliacaoRequest avaliacaoRequest, Restaurante restaurante, Usuario usuario) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(avaliacaoRequest.nota());
        avaliacao.setComentario(avaliacaoRequest.comentario());
        avaliacao.setData(avaliacaoRequest.data());
        avaliacao.setRestaurante(restaurante);
        avaliacao.setUsuario(usuario);
        return avaliacao;
    }


    public AvaliacaoResponse toResponse(Avaliacao avaliacao) {
        return new AvaliacaoResponse(
                avaliacao.getId(),
                avaliacao.getComentario(),
                avaliacao.getNota(),
                avaliacao.getData().toString(),
                usuarioMapper.toResponse(avaliacao.getUsuario()),
                restauranteMapper.toResponse(avaliacao.getRestaurante())

        );
    }
}


