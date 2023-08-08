package com.br.restaurantedelivery.cliente.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.restaurantedelivery.cliente.domain.Cliente;

import lombok.Value;

@Value
public class ClienteResponse {
	
	private UUID idCliente;
    private String nomeCliente;
    private String telefone;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataDaAlteracaoDoCadastro;
    
    public ClienteResponse(Cliente cliente) {
    	 this.idCliente = cliente.getIdCliente();
         this.nomeCliente = cliente.getNomeCliente();
         this.telefone = cliente.getTelefone();
         this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
         this.dataDaAlteracaoDoCadastro = cliente.getDataDaAlteracaoDoCadastro();
    }

}
