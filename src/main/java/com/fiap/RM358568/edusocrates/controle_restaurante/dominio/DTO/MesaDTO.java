package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MesaDTO {
    private Long id;
    private int numero;
    private int capacidade;
    private String status;
    private Long restauranteId;
    private List<Long> reservasIds;


}
