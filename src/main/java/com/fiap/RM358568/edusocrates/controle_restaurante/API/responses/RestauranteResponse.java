package com.fiap.RM358568.edusocrates.controle_restaurante.API.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestauranteResponse {

    private Long id;
    private String nome;
    private String localizacao;
    private String tipoDeCozinha;
    private String horariosFuncionamento;
    private int capacidade;
    private List<MesaResponse> mesas;
}
