package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservaRequest(
        @NotNull Long restauranteId,
        @NotNull Long mesaId,
        @NotNull Long usuarioId,
        @NotBlank String data,
        @NotBlank String horario,
        @NotNull int numeroDePessoas,
        @NotBlank String status
) {}

