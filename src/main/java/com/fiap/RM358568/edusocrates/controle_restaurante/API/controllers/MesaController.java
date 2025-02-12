package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;


import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.MesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaUseCase mesaUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<MesaDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(mesaUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<MesaDTO> salvar(@Validated @RequestBody MesaDTO dto) {
        return ResponseEntity.ok(mesaUseCase.salvar(dto));
    }
}