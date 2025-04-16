package com.edteam.restaurant_reservation.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generar los getter y setter
@NoArgsConstructor // Genera un constructor sin argumentos
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se genere en automatico el id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
