package com.fiap.RM358568.edusocrates.controle_restaurante.integrados;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.ReservaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class ReservaServiceIT {

    @Autowired
    private ReservaService reservaService;

    private ReservaDTO novaReserva;

    @BeforeEach
    public void setup() {
        novaReserva = new ReservaDTO(1L, "2025-01-01", "20:00", 4, "Confirmada", 1L, 1L, 1L);
    }

    @Test
    public void deveSalvarReservaComSucesso() {
        ReservaDTO salva = reservaService.salvar(novaReserva);
        assertThat(salva).isNotNull();
        assertThat(salva.getId()).isNotNull();
    }
}