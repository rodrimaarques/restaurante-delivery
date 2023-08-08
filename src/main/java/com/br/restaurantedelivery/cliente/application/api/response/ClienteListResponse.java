package com.br.restaurantedelivery.cliente.application.api.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.br.restaurantedelivery.cliente.domain.Cliente;

import lombok.Value;

@Value
public class ClienteListResponse {
	
	private UUID idCliente;
	private String nomeCliente;
	private String telefone;
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataDaAlteracaoDoCadastro;
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteListResponse::new)
				.collect(Collectors.toList());
	}

	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.telefone = cliente.getTelefone();
		this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
		this.dataDaAlteracaoDoCadastro = cliente.getDataDaAlteracaoDoCadastro();
	}

}
