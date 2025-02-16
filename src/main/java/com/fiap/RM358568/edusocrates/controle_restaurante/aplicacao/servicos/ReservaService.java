package com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.mapper.ReservaMapper;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.ReservaUseCase;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Mesa;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Reserva;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Restaurante;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.Usuario;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.MesaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.ReservaRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.RestauranteRepository;
import com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservaService implements ReservaUseCase {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public List<ReservaDTO> buscarPorRestaurante(Long restauranteId) {
        return reservaRepository.findByRestauranteId(restauranteId).stream().map(reservaMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ReservaDTO salvar(ReservaDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado."));
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        Mesa mesa = mesaRepository.findById(dto.getMesaId()).orElseThrow(() -> new RuntimeException("Mesa não encontrada."));

        Reserva reserva = reservaMapper.toEntity(dto, restaurante, mesa, usuario);
        reserva = reservaRepository.save(reserva);
        return reservaMapper.toDTO(reserva);
    }
}
