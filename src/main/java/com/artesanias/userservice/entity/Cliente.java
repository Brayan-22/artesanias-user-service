package com.artesanias.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @Size(max = 36)
    @Column(name = "id_clientepk", nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idClientepk;

    @OneToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuariofk", nullable = false)
    private UserEntity idUsuariofk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_ubicacionfk", nullable = false)
    private Ubicacion idUbicacionfk;

    @Size(max = 32)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 32)
    private String nombres;

    @Size(max = 32)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 32)
    private String apellidos;

    @Size(max = 32)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 32)
    private String direccion;

}