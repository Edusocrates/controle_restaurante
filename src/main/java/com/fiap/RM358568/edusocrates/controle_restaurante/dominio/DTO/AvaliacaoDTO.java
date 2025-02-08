package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.DTO;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class AvaliacaoDTO {
    private Long id;
    private int nota;
    private String comentario;
    private String data;
    private Long restauranteId;
    private Long usuarioId;


}
