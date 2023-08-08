package com.br.restaurantedelivery.cliente.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteListResponse;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteResponse;
import com.br.restaurantedelivery.cliente.application.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
	
	private final ClienteService clienteService;

	@Override
	public ClienteResponse salvaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}
	
	@Override
	public List<ClienteListResponse> buscaTodosClientesCadastrados() {
		log.info("[inicia] ClienteController - buscaTodosClientesCadastrados");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientesCadastrados();
		log.info("[finaliza] ClienteController - buscaTodosClientesCadastrados");
		return clientes;
	}

}
