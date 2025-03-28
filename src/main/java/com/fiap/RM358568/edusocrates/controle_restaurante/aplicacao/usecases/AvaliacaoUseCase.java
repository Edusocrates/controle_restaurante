package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.AvaliacaoMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.AvaliacaoGateway;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvaliacaoUseCase {


    @Autowired
    private AvaliacaoGateway avaliacaoGateway;

    @Autowired
    private RestauranteGateway restauranteGateway;

    @Autowired
    private UsuarioGateway usuarioGateway;

    @Autowired
    private AvaliacaoMapper avaliacaoMapper;

     public List<AvaliacaoResponse> buscarPorRestaurante(Long restauranteId) {
         return avaliacaoGateway.findByRestauranteId(restauranteId)
                 .stream()
                 .map(avaliacaoMapper::toResponse)
                 .collect(Collectors.toList());
     }

    @Transactional
    public AvaliacaoResponse salvar(AvaliacaoRequest avaliacaoRequest) {
        Restaurante restaurante = restauranteGateway.findById(avaliacaoRequest.restauranteId());
        Usuario usuario = usuarioGateway.findById(avaliacaoRequest.usuarioId());

        Avaliacao avaliacao = avaliacaoMapper.toEntity(avaliacaoRequest, restaurante, usuario);
        avaliacao = avaliacaoGateway.save(avaliacao);
        return avaliacaoMapper.toResponse(avaliacao);
    }
}
