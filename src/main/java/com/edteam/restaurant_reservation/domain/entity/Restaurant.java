package com.edteam.restaurant_reservation.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generar los getter y setter
@NoArgsConstructor // Genera un constructor sin argumentos
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se genere en automatico el id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "price_per_person", nullable = false)
    private double pricePerPerson;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false, foreignKey = @ForeignKey(name = "FK_RESTAURANT_DISTRICT"))
    private District district;

}
