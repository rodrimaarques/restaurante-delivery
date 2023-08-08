package com.br.restaurantedelivery.cliente.application.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ClienteRequest {
	
	@NotBlank(message = "Insira seu nome")
    private String nomeCliente;
    @NotBlank (message = "Insira um telefone")
    private String telefone;

}
