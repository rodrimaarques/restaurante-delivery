package com.br.restaurantedelivery.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteAlteracaoRequest;
import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idCliente;
	@NotBlank(message = "Insira o nome do cliente")
	private String nomeCliente;
	@NotBlank(message = "Insira um numero de telefone")
	private String telefone;
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataDaAlteracaoDoCadastro;
	
	
	public Cliente(@NotBlank(message = "Insira o nome do cliente") String nomeCliente,
			@NotBlank(message = "Insira um numero de telefone") String telefone, LocalDateTime dataHoraDoCadastro,
			LocalDateTime dataDaAlteracaoDoCadastro) {
		super();
		this.nomeCliente = nomeCliente;
		this.telefone = telefone;
		this.dataHoraDoCadastro = LocalDateTime.now();
		this.dataDaAlteracaoDoCadastro = LocalDateTime.now();
	}


	public Cliente(@Valid ClienteRequest clienteRequest) {
		
		this.nomeCliente = clienteRequest.getNomeCliente();
		this.telefone = clienteRequest.getNomeCliente();
		this.dataHoraDoCadastro = LocalDateTime.now();
		this.dataDaAlteracaoDoCadastro = LocalDateTime.now();
	}


	public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
		 this.nomeCliente = clienteAlteracaoRequest.getNomeCliente();
	        this.telefone = clienteAlteracaoRequest.getTelefone();
	        this.dataDaAlteracaoDoCadastro = LocalDateTime.now();
	    }
		
}
	
