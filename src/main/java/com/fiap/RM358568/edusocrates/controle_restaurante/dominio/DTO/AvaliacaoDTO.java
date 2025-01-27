package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoDTO {
    private Long id;
    private int nota;
    private String comentario;
    private String data;
    private Long restauranteId;
    private Long usuarioId;


}
