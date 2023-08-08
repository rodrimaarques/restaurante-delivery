package com.br.restaurantedelivery.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.restaurantedelivery.cliente.domain.Cliente;

public interface ClienteSpringJPARepository extends JpaRepository <Cliente, UUID>{

}
