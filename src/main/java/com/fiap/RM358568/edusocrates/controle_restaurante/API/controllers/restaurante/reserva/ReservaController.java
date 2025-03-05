package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.reserva;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.ReservaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.ReservaResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.ReservaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reservas", description = "Operações relacionadas as reservas de mesas")
public class ReservaController {

    @Autowired
    private ReservaUseCase reservaUseCase;

    @GetMapping("/restaurante/{restauranteId}")
    @Tag(name = "Buscar reservas por restaurante", description = "Buscar todas as reservas de um restaurante")
    @Operation(summary = "Buscar reservas por restaurante", description = "Buscar todas as reservas de um restaurante")
    public ResponseEntity<List<ReservaResponse>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(reservaUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    @Tag(name = "Salvar reserva", description = "Salvar uma nova reserva")
    @Operation(summary = "Salvar reserva", description = "Salvar uma nova reserva")
    public ResponseEntity<ReservaResponse> salvar(@Validated @RequestBody ReservaRequest reservaRequest) {
        return ResponseEntity.ok(reservaUseCase.salvar(reservaRequest));
    }
}
