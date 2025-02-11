package com.artesanias.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "\"User\"")
@Table(name = "\"usuario\"")
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "\"id_usuario\"")
    @Id
    private String id;
    @Column(name = "\"password\"")
    private String password;
    @Column(name = "\"role\"")
    private String role;
    @Column(name = "\"mail\"")
    private String email;

}
