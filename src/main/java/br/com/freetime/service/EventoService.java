package br.com.freetime.service;

import java.util.List;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.model.Categoria;
import br.com.freetime.model.Evento;

public interface EventoService {

	void incluir(Evento evento);

	void deletar(long id) throws CampoObrigatorioException;

	void atualizar(long idEvento, Evento eventoAtual) throws CampoObrigatorioException;

	List<Evento> buscarEventos();
	
	void adicionarCategoria(long idEvento, List<Categoria> categorias);


}
