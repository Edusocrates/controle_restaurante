package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.RestauranteRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.RestauranteResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.RestauranteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@Tag(name = "Configurações restaurante", description = "Operações relacionadas as configurações e funcionamento do restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteUseCase restauranteUseCase;

    @GetMapping
    @Tag(name = "Listar restaurantes", description = "Listar todos os restaurantes cadastrados")
    @Operation(summary = "Listar restaurantes", description = "Listar todos os restaurantes cadastrados")
    public ResponseEntity<List<RestauranteResponse>> buscarTodos() {
        return ResponseEntity.ok(restauranteUseCase.buscarTodos());
    }

    @GetMapping("/{id}")
    @Tag(name = "Buscar restaurante por ID", description = "Buscar um restaurante por ID")
    @Operation(summary = "Buscar restaurante por ID", description = "Buscar um restaurante por ID")
    public ResponseEntity<RestauranteResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteUseCase.buscarPorId(id));
    }

    @PostMapping
    @Tag(name = "Salvar restaurante", description = "Salvar um novo restaurante")
    @Operation(summary = "Salvar restaurante", description = "Salvar um novo restaurante")
    public ResponseEntity<RestauranteResponse> salvar(@Validated @RequestBody RestauranteRequest restauranteRequest) {
        return ResponseEntity.ok(restauranteUseCase.salvar(restauranteRequest));
    }
}
