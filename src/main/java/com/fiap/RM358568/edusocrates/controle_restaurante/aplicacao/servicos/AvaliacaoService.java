package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.AvaliacaoMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.AvaliacaoRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvaliacaoMapper avaliacaoMapper;

    public List<AvaliacaoDTO> buscarPorRestaurante(Long restauranteId) {
        return avaliacaoRepository.findByRestauranteId(restauranteId).stream().map(avaliacaoMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public AvaliacaoDTO salvar(AvaliacaoDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Avaliacao avaliacao = avaliacaoMapper.toEntity(dto, restaurante, usuario);
        avaliacao = avaliacaoRepository.save(avaliacao);
        return avaliacaoMapper.toDTO(avaliacao);
    }
}