package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers;

import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.servicos.RestauranteService;
import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> buscarTodos() {
        return ResponseEntity.ok(restauranteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> salvar(@Validated @RequestBody RestauranteDTO dto) {
        return ResponseEntity.ok(restauranteService.salvar(dto));
    }
}
