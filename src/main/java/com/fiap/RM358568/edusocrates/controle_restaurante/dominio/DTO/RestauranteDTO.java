package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestauranteDTO {
    private Long id;
    private String nome;
    private String localizacao;
    private String tipoDeCozinha;
    private String horariosFuncionamento;
    private int capacidade;
    private List<MesaDTO> mesas;


}