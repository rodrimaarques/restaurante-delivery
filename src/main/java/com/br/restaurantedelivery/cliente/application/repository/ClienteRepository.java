package com.br.restaurantedelivery.cliente.application.repository;

import java.util.List;

import com.br.restaurantedelivery.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salvaCliente(Cliente cliente);

	List<Cliente> buscaTodosClientesCadastrados();

}
