package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.mesa;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.MesaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
@Tag(name = "Mesas", description = "Operações relacionadas as mesas do restaurante")
public class MesaController {

    @Autowired
    private MesaUseCase mesaUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    @Tag(name = "Buscar mesas por restaurante", description = "Buscar todas as mesas de um restaurante")
    @Operation(summary = "Buscar mesas por restaurante", description = "Buscar todas as mesas de um restaurante")
    public ResponseEntity<List<MesaResponse>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(mesaUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    @Tag(name = "Salvar mesa", description = "Salvar uma nova mesa")
    @Operation(summary = "Salvar mesa", description = "Salvar uma nova mesa")
    public ResponseEntity<MesaResponse> salvar(@Validated @RequestBody MesaRequest mesaRequest) {
        return ResponseEntity.ok(mesaUseCase.salvar(mesaRequest));
    }
}