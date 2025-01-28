package com.fiap.RM358568.edusocrates.controle_restaurante.integrados;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.RestauranteService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
public class RestauranteServiceIT {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @BeforeEach
    public void setup() {
        Restaurante restaurante1 = new Restaurante(null, "Restaurante A", "Rua A", "Italiana", "09:00-22:00", 50, null, null, null);
        Restaurante restaurante2 = new Restaurante(null, "Restaurante B", "Rua B", "Japonesa", "10:00-23:00", 30, null, null, null);
        restauranteRepository.save(restaurante1);
        restauranteRepository.save(restaurante2);
    }

    @Test
    public void deveBuscarTodosOsRestaurantes() {
        List<RestauranteDTO> restaurantes = restauranteService.buscarTodos();

        assertThat(restaurantes).isNotNull();
        assertThat(restaurantes.size()).isEqualTo(2);
        assertThat(restaurantes.get(0).getNome()).isEqualTo("Restaurante A");
        assertThat(restaurantes.get(1).getNome()).isEqualTo("Restaurante B");
    }

    @Test
    public void deveSalvarRestauranteComSucesso() {
        RestauranteDTO novoRestaurante = new RestauranteDTO(
                null,
                "Restaurante C",
                "Rua C",
                "Brasileira",
                "08:00-20:00",
                40,
                new ArrayList<MesaDTO>()
        );

        RestauranteDTO restauranteSalvo = restauranteService.salvar(novoRestaurante);

        assertThat(restauranteSalvo).isNotNull();
        assertThat(restauranteSalvo.getId()).isNotNull();
        assertThat(restauranteSalvo.getNome()).isEqualTo("Restaurante C");

        List<Restaurante> todosRestaurantes = restauranteRepository.findAll();
        assertThat(todosRestaurantes.size()).isEqualTo(3);
    }

    @Test
    public void deveBuscarRestaurantePorId() {
        Restaurante restaurante = restauranteRepository.findAll().get(0);

        RestauranteDTO restauranteDTO = restauranteService.buscarPorId(restaurante.getId());

        assertThat(restauranteDTO).isNotNull();
        assertThat(restauranteDTO.getId()).isEqualTo(restaurante.getId());
        assertThat(restauranteDTO.getNome()).isEqualTo(restaurante.getNome());
    }
}

