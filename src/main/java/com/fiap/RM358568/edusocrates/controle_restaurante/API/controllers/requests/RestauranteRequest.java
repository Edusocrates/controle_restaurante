package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RestauranteRequest(
        @NotBlank String nome,
        @NotBlank String localizacao,
        @NotBlank String tipoDeCozinha,
        @NotBlank String horariosFuncionamento,
        @Min(1) int capacidade,
        List<MesaRequest> mesas
) {}

