package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDTO {
    private Long id;
    private String data;
    private String horario;
    private int numeroDePessoas;
    private String status;
    private Long restauranteId;
    private Long mesaId;
    private Long usuarioId;


}
