package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.avaliacao;


import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.AvaliacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoUseCase avaliacaoUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<AvaliacaoDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(avaliacaoUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> salvar(@Validated @RequestBody AvaliacaoDTO dto) {
        return ResponseEntity.ok(avaliacaoUseCase.salvar(dto));
    }
}

