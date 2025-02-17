package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<Long> reservasIds;
    private List<Long> avaliacoesIds;
}
