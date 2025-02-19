package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.AvaliacaoGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.AvaliacaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AvaliacaoRepositoryGateway implements AvaliacaoGateway {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoRepositoryGateway(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }


    @Override
    public List<Avaliacao> findByRestauranteId(Long restauranteId) {
        return avaliacaoRepository.findByRestauranteId(restauranteId);
    }

    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public Optional<Avaliacao> findById(Long id) {
        return avaliacaoRepository.findById(id);
    }
}
