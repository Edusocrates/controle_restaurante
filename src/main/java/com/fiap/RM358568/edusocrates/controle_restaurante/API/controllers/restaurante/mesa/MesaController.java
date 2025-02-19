package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.restaurante.mesa;


import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.MesaRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.MesaResponse;
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
    public ResponseEntity<List<MesaResponse>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(mesaUseCase.buscarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<MesaResponse> salvar(@Validated @RequestBody MesaRequest mesaRequest) {
        return ResponseEntity.ok(mesaUseCase.salvar(mesaRequest));
    }
}