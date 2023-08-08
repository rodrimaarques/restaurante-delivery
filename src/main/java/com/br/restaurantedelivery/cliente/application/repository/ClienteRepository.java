package com.br.restaurantedelivery.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import com.br.restaurantedelivery.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salvaCliente(Cliente cliente);

	List<Cliente> buscaTodosClientesCadastrados();

	Cliente buscaClientePorId(UUID idCliente);

	void deletaCliente(Cliente cliente);

}
