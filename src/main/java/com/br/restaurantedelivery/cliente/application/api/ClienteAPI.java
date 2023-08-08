package com.br.restaurantedelivery.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.restaurantedelivery.cliente.application.api.request.ClienteAlteracaoRequest;
import com.br.restaurantedelivery.cliente.application.api.request.ClienteRequest;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteDetalhadoResponse;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteListResponse;
import com.br.restaurantedelivery.cliente.application.api.response.ClienteResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse salvaCliente(@Valid @RequestBody ClienteRequest clienteRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteListResponse> buscaTodosClientesCadastrados();
	
	 @GetMapping(value = "/{idCliente}")
	    @ResponseStatus(HttpStatus.OK)
	    ClienteDetalhadoResponse buscaClientePorId(@PathVariable UUID idCliente);
	 
	 @PatchMapping(value = "/{idCliente}")
		@ResponseStatus(code = HttpStatus.ACCEPTED)
		void alteraCliente(@PathVariable UUID idCliente, @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);
	 
	 @DeleteMapping(value = "/{idCliente}")
	    @ResponseStatus(value = HttpStatus.ACCEPTED)
	    void deletaCliente(@PathVariable UUID idCliente);

}
