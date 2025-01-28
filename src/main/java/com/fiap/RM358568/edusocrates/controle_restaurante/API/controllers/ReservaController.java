package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.ReservaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.ReservaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<ReservaDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(reservaService.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@Validated @RequestBody ReservaDTO dto) {
        return ResponseEntity.ok(reservaService.salvar(dto));
    }
}
