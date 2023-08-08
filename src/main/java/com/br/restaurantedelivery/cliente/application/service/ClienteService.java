package com.br.restaurantedelivery.cliente.application.service;

import java.util.List;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteListResponse;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteResponse;

import jakarta.validation.Valid;

public interface ClienteService {

	ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);

	List<ClienteListResponse> buscaTodosClientesCadastrados();

}
