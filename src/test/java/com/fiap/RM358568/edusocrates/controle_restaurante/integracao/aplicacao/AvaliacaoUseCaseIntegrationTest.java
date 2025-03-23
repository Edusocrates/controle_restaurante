package com.fiap.RM358568.edusocrates.controle_restaurante.integracao.aplicacao;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.AvaliacaoUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Avaliacao;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.AvaliacaoGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.RestauranteGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways.UsuarioGateway;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.mapper.AvaliacaoMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AvaliacaoUseCaseIntegrationTest {

    @InjectMocks
    private AvaliacaoUseCase avaliacaoUseCase;

    @Mock
    private AvaliacaoGateway avaliacaoGateway;

    @Mock
    private RestauranteGateway restauranteGateway;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Mock
    private AvaliacaoMapper avaliacaoMapper;

    @Test
    void buscarPorRestaurante_deveRetornarListaDeAvaliacoes() {
        Long restauranteId = 1L;
        Avaliacao avaliacao = new Avaliacao();
        AvaliacaoResponse response = new AvaliacaoResponse();

        when(avaliacaoGateway.findByRestauranteId(restauranteId)).thenReturn(Collections.singletonList(avaliacao));
        when(avaliacaoMapper.toResponse(avaliacao)).thenReturn(response);

        List<AvaliacaoResponse> resultado = avaliacaoUseCase.buscarPorRestaurante(restauranteId);

        assertNotNull(resultado);
        verify(avaliacaoGateway).findByRestauranteId(restauranteId);
    }

    @Test
    void salvar_deveCriarNovaAvaliacao() {
        AvaliacaoRequest request = new AvaliacaoRequest(1L, 1L, 5, "Ótimo restaurante!", "2021-10-10");
        Restaurante restaurante = new Restaurante();
        Usuario usuario = new Usuario();
        Avaliacao avaliacao = new Avaliacao();
        AvaliacaoResponse response = new AvaliacaoResponse();

        when(restauranteGateway.findById(any())).thenReturn(restaurante);
        when(usuarioGateway.findById(any())).thenReturn(usuario);
        when(avaliacaoMapper.toEntity(any(), any(), any())).thenReturn(avaliacao);
        when(avaliacaoGateway.save(any())).thenReturn(avaliacao);
        when(avaliacaoMapper.toResponse(any())).thenReturn(response);

        AvaliacaoResponse resultado = avaliacaoUseCase.salvar(request);

        assertNotNull(resultado);
        verify(avaliacaoGateway).save(avaliacao);
    }
}