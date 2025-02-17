package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoRequest(
        @NotNull Long restauranteId,
        @NotNull Long usuarioId,
        @Min(1) @Max(5) int nota,
        @NotBlank String comentario,
        @NotBlank String data
) {}
