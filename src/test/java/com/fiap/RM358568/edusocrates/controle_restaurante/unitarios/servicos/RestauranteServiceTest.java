package com.fiap.RM358568.edusocrates.controle_restaurante.unitarios.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.RestauranteMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.RestauranteService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestauranteServiceTest {

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private RestauranteMapper restauranteMapper;

    @InjectMocks
    private RestauranteService restauranteService;

    private Restaurante restaurante;
    private RestauranteDTO restauranteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        restaurante = new Restaurante();
        restaurante.setId(1L);
        restaurante.setNome("Restaurante Exemplo");
        restaurante.setLocalizacao("Localização Exemplo");
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setCapacidade(50);
        restaurante.setHorariosFuncionamento("9h-22h");

        restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(1L);
        restauranteDTO.setNome("Restaurante Exemplo");
        restauranteDTO.setLocalizacao("Localização Exemplo");
        restauranteDTO.setTipoDeCozinha("Italiana");
        restauranteDTO.setCapacidade(50);
        restauranteDTO.setHorariosFuncionamento("9h-22h");
    }

    @Test
    void buscarTodos_DeveRetornarListaDeRestaurantes() {
        when(restauranteRepository.findAll()).thenReturn(List.of(restaurante));
        when(restauranteMapper.toDTO(restaurante)).thenReturn(restauranteDTO);

        List<RestauranteDTO> resultado = restauranteService.buscarTodos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(restauranteDTO.getNome(), resultado.get(0).getNome());
        verify(restauranteRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId_DeveRetornarRestauranteQuandoEncontrado() {
        when(restauranteRepository.findById(1L)).thenReturn(Optional.of(restaurante));
        when(restauranteMapper.toDTO(restaurante)).thenReturn(restauranteDTO);

        RestauranteDTO resultado = restauranteService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(restauranteDTO.getNome(), resultado.getNome());
        verify(restauranteRepository, times(1)).findById(1L);
    }

    @Test
    void buscarPorId_DeveLancarExcecaoQuandoNaoEncontrado() {
        when(restauranteRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> restauranteService.buscarPorId(1L));

        assertEquals("Restaurante não encontrado.", exception.getMessage());
        verify(restauranteRepository, times(1)).findById(1L);
    }

    @Test
    void salvar_DevePersistirERetornarRestaurante() {
        when(restauranteMapper.toEntity(restauranteDTO)).thenReturn(restaurante);
        when(restauranteRepository.save(restaurante)).thenReturn(restaurante);
        when(restauranteMapper.toDTO(restaurante)).thenReturn(restauranteDTO);

        RestauranteDTO resultado = restauranteService.salvar(restauranteDTO);

        assertNotNull(resultado);
        assertEquals(restauranteDTO.getNome(), resultado.getNome());
        verify(restauranteRepository, times(1)).save(restaurante);
    }
}

