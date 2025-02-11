package com.artesanias.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "ubicacion")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ubicacion {
    @Id
    @Column(name = "id_ubicacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 64)
    private String direccion;

}