package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante;


import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO.RestauranteDTO;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteUseCase restauranteUseCase;

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> buscarTodos() {
        return ResponseEntity.ok(restauranteUseCase.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteUseCase.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> salvar(@Validated @RequestBody RestauranteDTO dto) {
        return ResponseEntity.ok(restauranteUseCase.salvar(dto));
    }
}
