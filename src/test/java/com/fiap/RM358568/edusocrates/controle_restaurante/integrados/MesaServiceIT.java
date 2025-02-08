package com.fiap.RM358568.edusocrates.controle_restaurante.integrados;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.MesaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class MesaServiceIT {

    @Autowired
    private MesaService mesaService;

    private MesaDTO novaMesa;

    @BeforeEach
    public void setup() {
        novaMesa = new MesaDTO(null, 10, 4, "DISPONIVEL", 1L, List.of());
    }

    @Test
    public void deveSalvarMesaComSucesso() {
        MesaDTO salva = mesaService.salvar(novaMesa);
        assertThat(salva).isNotNull();
        assertThat(salva.getId()).isNotNull();
    }
}
