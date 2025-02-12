package com.fiap.RM358568.edusocrates.controle_restaurante.dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    private int nota;

    @NotBlank(message = "O comentário não pode estar vazio")
    private String comentario;

    @NotBlank(message = "A data não pode estar vazia")
    private String data;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}