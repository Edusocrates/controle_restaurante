package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "mesa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "O número da mesa deve ser maior que zero")
    private int numero;

    @Min(value = 1, message = "A capacidade da mesa deve ser maior que zero")
    private int capacidade;

    @NotBlank(message = "O status da mesa não pode estar vazio")
    private String status;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
