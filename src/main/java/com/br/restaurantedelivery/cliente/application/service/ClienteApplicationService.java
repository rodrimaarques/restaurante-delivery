package com.br.restaurantedelivery.cliente.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteListResponse;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteResponse;
import com.br.restaurantedelivery.cliente.application.repository.ClienteRepository;
import com.br.restaurantedelivery.cliente.domain.Cliente;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salvaCliente(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return new ClienteResponse(cliente);
	}
	
	@Override
	public List<ClienteListResponse> buscaTodosClientesCadastrados() {
		log.info("[inicia] ClienteApplicationService - buscaTodosClientesCadastrados");
		List<Cliente> clientes = clienteRepository.buscaTodosClientesCadastrados();
		log.info("[finaliza] ClienteApplicationService - buscaTodosClientesCadastrados");
		return ClienteListResponse.converte(clientes);
		
	}

}
