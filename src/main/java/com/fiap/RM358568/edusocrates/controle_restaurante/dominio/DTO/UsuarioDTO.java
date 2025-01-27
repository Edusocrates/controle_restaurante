package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<Long> reservasIds;
    private List<Long> avaliacoesIds;


}
