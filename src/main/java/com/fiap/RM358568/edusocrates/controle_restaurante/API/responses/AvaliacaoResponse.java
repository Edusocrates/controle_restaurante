package com.fiap.RM358568.edusocrates.controle_restaurante.API.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoResponse {
    private Long id;
    private String comentario;
    private int nota;
    private String data;
    private UsuarioResponse usuario;
    private RestauranteResponse restaurante;


}

