package com.fiap.RM358568.edusocrates.controle_restaurante.API.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaResponse {

    private Long id;
    private int numero;
    private int capacidade;
    private String status;
    private Long restauranteId;
    private List<Long> reservasIds;
}
