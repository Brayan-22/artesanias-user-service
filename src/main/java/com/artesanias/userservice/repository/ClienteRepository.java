package com.artesanias.userservice.repository;

import com.artesanias.userservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}