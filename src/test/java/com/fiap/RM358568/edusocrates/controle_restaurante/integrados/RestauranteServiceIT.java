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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class RestauranteServiceIT {

    @Autowired
    private RestauranteService restauranteService;

    private RestauranteDTO novoRestaurante;

    @BeforeEach
    public void setup() {
        novoRestaurante = new RestauranteDTO(null, "Restaurante C", "Rua C", "Brasileira", "08:00-20:00", 40, List.of());
    }

    @Test
    public void deveSalvarRestauranteComSucesso() {
        RestauranteDTO salvo = restauranteService.salvar(novoRestaurante);
        assertThat(salvo).isNotNull();
        assertThat(salvo.getId()).isNotNull();
    }
}
