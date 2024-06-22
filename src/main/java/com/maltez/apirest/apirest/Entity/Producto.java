package com.maltez.apirest.apirest.Entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
}
