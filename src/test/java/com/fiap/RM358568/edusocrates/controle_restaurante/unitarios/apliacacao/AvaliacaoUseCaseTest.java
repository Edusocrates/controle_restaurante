package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.apliacacao;

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
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AvaliacaoUseCaseTest {

    @InjectMocks
    private AvaliacaoUseCase avaliacaoUseCase;

    @Mock
    private AvaliacaoGateway avaliacaoGateway;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private AvaliacaoMapper avaliacaoMapper;

    @Mock
    private RestauranteGateway restauranteGateway;

    @Mock
    private UsuarioGateway usuarioGateway;

    @Test
    void buscarPorRestaurante_DeveRetornarListaDeAvaliacaoResponse() {
        Long restauranteId = 1L;
        List<Avaliacao> avaliacoes = List.of(new Avaliacao());
        List<AvaliacaoResponse> responses = List.of(new AvaliacaoResponse());

        when(avaliacaoGateway.findByRestauranteId(restauranteId)).thenReturn(avaliacoes);
        when(avaliacaoMapper.toResponse(any())).thenReturn(responses.get(0));

        List<AvaliacaoResponse> resultado = avaliacaoUseCase.buscarPorRestaurante(restauranteId);

        assertEquals(1, resultado.size());
        verify(avaliacaoGateway).findByRestauranteId(restauranteId);
    }

    @Test
    void salvar_DeveSalvarAvaliacaoERetornarResponse() {
        AvaliacaoRequest request = new AvaliacaoRequest(1L, 1L, 5, "Ótimo!", "2021-10-10");
        Restaurante restaurante = new Restaurante();
        Usuario usuario = new Usuario();
        Avaliacao avaliacao = new Avaliacao();
        AvaliacaoResponse response = new AvaliacaoResponse();

        lenient().when(restauranteRepository.findById(any())).thenReturn(Optional.of(restaurante));
        lenient().when(usuarioRepository.findById(any())).thenReturn(Optional.of(usuario));
        when(avaliacaoMapper.toEntity(any(), any(), any())).thenReturn(avaliacao);
        when(avaliacaoGateway.save(any())).thenReturn(avaliacao);
        when(avaliacaoMapper.toResponse(any())).thenReturn(response);

        AvaliacaoResponse resultado = avaliacaoUseCase.salvar(request);

        assertNotNull(resultado);
        verify(avaliacaoGateway).save(avaliacao);
    }
}

