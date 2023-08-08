package com.br.restaurantedelivery.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.br.restaurantedelivery.cliente.application.repository.ClienteRepository;
import com.br.restaurantedelivery.cliente.domain.Cliente;
import com.br.restaurantedelivery.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
	
	private final ClienteSpringJPARepository clienteSpringJPARepository;
	
	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salvaCliente ");
		try {
			clienteSpringJPARepository.save(cliente);
			log.info("[sucesso] ClienteInfraRepository - salvaCliente: Cliente cadastrado com " + "sucesso: {}",
					cliente.getIdCliente());
			return cliente;
		} catch (DataIntegrityViolationException e) {
			log.error("[erro] ClienteInfraRepository - salvaCliente: Erro ao salvar cliente:" + " {}",
					e.getMessage());
			throw APIException.build(HttpStatus.BAD_REQUEST,
					"Erro ao salvar cliente. Verifique os dados informados.");
		} finally {
			log.info("[finaliza] ClienteInfraRepository - salvaCliente ");
		}
	}
	
	 @Override
	  	public List<Cliente> buscaTodosClientesCadastrados() {
			log.info("[inicia] ClienteInfraRepository - buscaTodosClientesCadastrados");
			List<Cliente> todosClientes = clienteSpringJPARepository.findAll();
			log.info("[finaliza] ClienteInfraRepository - buscaTodosClientesCadastrados");
			return todosClientes;
		}
	 
	 @Override
		public Cliente buscaClientePorId(UUID idCliente) {
			log.info("[Start] ClienteInfraRepository - buscaClientePorId");
			Cliente cliente = clienteSpringJPARepository.findById(idCliente)
					.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
			log.info("[Finish] ClienteInfraRepository - buscaClientePorId");
			return cliente;
		}
}
