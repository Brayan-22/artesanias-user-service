package com.artesanias.userservice.repository;

import com.artesanias.userservice.entity.Ubicacion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
  Optional<Ubicacion> findByDireccion(@Size(max = 64) @NotNull String direccion);
}