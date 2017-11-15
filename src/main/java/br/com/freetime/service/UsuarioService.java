package br.com.freetime.service;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.model.Usuario;

public interface UsuarioService {
	
	public void incluir(Usuario usuario);

	void deletar(String login) throws CampoObrigatorioException;

	void atualizar(Usuario usuario) throws CampoObrigatorioException;
}
