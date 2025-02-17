package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "restaurante")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do restaurante não pode estar em branco")
    private String nome;

    @NotBlank(message = "A localização do restaurante não pode estar em branco")
    private String localizacao;
    @NotBlank(message = "O tipo de cozinha não pode estar em branco")
    private String tipoDeCozinha;

    @NotBlank(message = "Os horários de funcionamento são obrigatórios")
    private String horariosFuncionamento;

    @Min(value = 1, message = "A capacidade deve ser de pelo menos 1 pessoa")
    private int capacidade;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mesa> mesas;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
