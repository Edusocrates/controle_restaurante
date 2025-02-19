package com.fiap.RM358568.edusocrates.controle_restaurante.API.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioRequest(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotBlank String telefone,
        List<Long> reservasIds,
        List<Long> avaliacoesIds
) {}
