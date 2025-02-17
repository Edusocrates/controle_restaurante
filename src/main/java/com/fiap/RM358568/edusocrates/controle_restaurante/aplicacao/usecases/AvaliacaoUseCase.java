package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.AvaliacaoMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.AvaliacaoRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvaliacaoUseCase {


    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvaliacaoMapper avaliacaoMapper;

     public List<AvaliacaoResponse> buscarPorRestaurante(Long restauranteId) {
         return avaliacaoRepository.findByRestauranteId(restauranteId)
                 .stream()
                 .map(avaliacaoMapper::toResponse)
                 .collect(Collectors.toList());
     }

    @Transactional
    public AvaliacaoResponse salvar(AvaliacaoRequest avaliacaoRequest) {
        Restaurante restaurante = restauranteRepository.findById(avaliacaoRequest.restauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));
        Usuario usuario = usuarioRepository.findById(avaliacaoRequest.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Avaliacao avaliacao = avaliacaoMapper.toEntity(avaliacaoRequest, restaurante, usuario);
        avaliacao = avaliacaoRepository.save(avaliacao);
        return avaliacaoMapper.toResponse(avaliacao);
    }
}
