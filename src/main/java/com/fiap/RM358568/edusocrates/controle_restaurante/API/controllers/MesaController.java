package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.MesaService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.MesaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<MesaDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(mesaService.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<MesaDTO> salvar(@Validated @RequestBody MesaDTO dto) {
        return ResponseEntity.ok(mesaService.salvar(dto));
    }
}