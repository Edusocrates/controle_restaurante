package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.AvaliacaoService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.AvaliacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<AvaliacaoDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(avaliacaoService.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> salvar(@Validated @RequestBody AvaliacaoDTO dto) {
        return ResponseEntity.ok(avaliacaoService.salvar(dto));
    }
}

