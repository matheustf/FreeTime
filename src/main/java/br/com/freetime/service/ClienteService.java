package br.com.freetime.service;

import java.util.List;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.model.Cliente;

public interface ClienteService {

	void incluir(Cliente cliente);

	void deletar(long id) throws CampoObrigatorioException;

	void atualizar(Cliente clienteAtual) throws CampoObrigatorioException;

	List<Cliente> buscarClientes();
	
}
