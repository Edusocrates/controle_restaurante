package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MesaRequest(
        @Min(1) int numero,
        @Min(1) int capacidade,
        @NotBlank String status,
        @NotNull Long restauranteId,
        @NotNull List<Long> reservasIds
) {}
