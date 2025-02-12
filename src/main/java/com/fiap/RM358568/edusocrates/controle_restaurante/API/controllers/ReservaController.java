package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.ReservaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaUseCase reservaUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<ReservaDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(reservaUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@Validated @RequestBody ReservaDTO dto) {
        return ResponseEntity.ok(reservaUseCase.salvar(dto));
    }
}
