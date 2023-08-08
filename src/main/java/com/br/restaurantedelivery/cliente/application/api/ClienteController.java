package com.br.restaurantedelivery.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteAlteracaoRequest;
import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteDetalhadoResponse;
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
	
	@Override
	public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - buscaClientePorId");
		ClienteDetalhadoResponse clienteDetalhadoResponse = clienteService.buscaClientePorId(idCliente);
		log.info("[finaliza] ClienteController - buscaClientePorId");
		return clienteDetalhadoResponse;
	}
	
	public void alteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteController - alteraCliente ");
		log.info("[idCliente] {}", idCliente);
		clienteService.alteraCliente(idCliente, clienteAlteracaoRequest);
		log.info("[finaliza] ClienteController - alteraCliente ");
	}

}
