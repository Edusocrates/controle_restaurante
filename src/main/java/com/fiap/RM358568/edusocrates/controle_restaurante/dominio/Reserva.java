package com.fiap.RM358568.edusocrates.controle_restaurante.dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A data da reserva não pode estar em branco")
    private String data;

    @NotBlank(message = "O horário da reserva não pode estar em branco")
    private String horario;

    @NotBlank(message = "O número de pessoas não pode estar em branco")
    private int numeroDePessoas;

    private String status;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}