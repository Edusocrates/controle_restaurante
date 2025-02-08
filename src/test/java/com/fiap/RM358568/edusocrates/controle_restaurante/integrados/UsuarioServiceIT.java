package com.fiap.RM358568.edusocrates.controle_restaurante.integrados;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.UsuarioService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.UsuarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class UsuarioServiceIT {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioDTO novoUsuario;

    @BeforeEach
    public void setup() {
        novoUsuario = new UsuarioDTO(null, "João Silva", "joao@email.com", "123456789", List.of(), List.of());
    }

    @Test
    public void deveSalvarUsuarioComSucesso() {
        UsuarioDTO salvo = usuarioService.salvar(novoUsuario);
        assertThat(salvo).isNotNull();
        assertThat(salvo.getId()).isNotNull();
    }
}
