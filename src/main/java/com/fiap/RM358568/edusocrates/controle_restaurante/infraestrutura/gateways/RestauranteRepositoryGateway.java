package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;

    public RestauranteRepositoryGateway(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public List<Restaurante> findByNomeContainingIgnoreCase(String nome) {
        return restauranteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Restaurante> findByLocalizacaoContainingIgnoreCase (String localizacao) {
        return restauranteRepository.findByLocalizacaoContainingIgnoreCase(localizacao);
    }

    @Override
    public List<Restaurante> findByTipoDeCozinhaContainingIgnoreCase (String tipoDeCozinha) {
        return restauranteRepository.findByTipoDeCozinhaContainingIgnoreCase(tipoDeCozinha);
    }

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante findById(Long id) {
        return restauranteRepository.findById(id).orElse(null);
    }

}
