package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.avaliacao;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.AvaliacaoRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.AvaliacaoResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.AvaliacaoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@Tag(name = "Avaliações", description = "Operações relacionadas as avaliações de restaurantes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoUseCase avaliacaoUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    @Tag(name = "Buscar avaliações por restaurante", description = "Buscar todas as avaliações de um restaurante")
    @Operation(summary = "Buscar avaliações por restaurante", description = "Buscar todas as avaliações de um restaurante")
    public ResponseEntity<List<AvaliacaoResponse>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(avaliacaoUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    @Tag(name = "Salvar avaliação", description = "Salvar uma nova avaliação")
    @Operation(summary = "Salvar avaliação", description = "Salvar uma nova avaliação")
    public ResponseEntity<AvaliacaoResponse> salvar(@Validated @RequestBody AvaliacaoRequest avaliacaoRequest) {
        return ResponseEntity.ok(avaliacaoUseCase.salvar(avaliacaoRequest));
    }
}

