package br.com.freetime.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.model.Cliente;
import br.com.freetime.repository.ClienteRepository;
import br.com.freetime.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private final Logger logger = Logger.getLogger(ClienteServiceImpl.class);

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void incluir(Cliente cliente) {
		logger.info("Incluindo cliente ...");

		clienteRepository.save(cliente);
	}

	@Override
	public void deletar(long id) throws CampoObrigatorioException {
		logger.info("Deletando cliente...");
		Cliente cliente = clienteRepository.findByIdStartsWithIgnoreCase(id);
		if (cliente == null) {
			logger.error("Erro ao deletar Cliente!");
			throw new CampoObrigatorioException("Cliente Nao encontrado para ser excluido!");
		}

		clienteRepository.delete(cliente);
	}

	@Override
	public void atualizar(Cliente clienteAtual) throws CampoObrigatorioException {
		logger.info("Atualizando cliente...");
		/*
		 * Pega o CEP elaborado na função buscaCep, caso o CEP não seja encontrado de
		 * primeira ira atribuir o primeiro CEP encontrado no algorítimo.
		 */
		Cliente cliente = clienteRepository.findByIdStartsWithIgnoreCase(clienteAtual.getId());
		if (cliente == null) {
			logger.error("Erro ao atualizar Cliente!");
			throw new CampoObrigatorioException("Cliente Nao encontrado para ser excluido!");
		}

		clienteRepository.save(clienteAtual);
	}

	@Override
	public List<Cliente> buscarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
}
