package br.com.freetime.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.model.Categoria;
import br.com.freetime.model.Evento;
import br.com.freetime.repository.EventoRepository;
import br.com.freetime.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService{

	private final Logger logger = Logger.getLogger(EventoServiceImpl.class);

	@Autowired
	EventoRepository eventoRepository;

	@Override
	public void incluir(Evento evento) {
		logger.info("Incluindo evento ...");

		eventoRepository.save(evento);
	}

	@Override
	public void deletar(long id) throws CampoObrigatorioException {
		logger.info("Deletando evento...");
		Evento evento = eventoRepository.findByIdStartsWithIgnoreCase(id);
		if (evento == null) {
			logger.error("Erro ao deletar Evento!");
			throw new CampoObrigatorioException("Evento Nao encontrado para ser excluido!");
		}

		eventoRepository.delete(evento);
	}

	@Override
	public void atualizar(long idEvento, Evento eventoAtual) throws CampoObrigatorioException {
		logger.info("Atualizando evento...");
		/*
		 * Pega o CEP elaborado na função buscaCep, caso o CEP não seja encontrado de
		 * primeira ira atribuir o primeiro CEP encontrado no algorítimo.
		 */
		Evento evento = eventoRepository.findByIdStartsWithIgnoreCase(idEvento);
		if (evento == null) {
			logger.error("Erro ao atualizar Evento!");
			throw new CampoObrigatorioException("Evento Nao encontrado para ser excluido!");
		}

		eventoRepository.save(eventoAtual);
	}

	@Override
	public List<Evento> buscarEventos() {
		List<Evento> eventos = eventoRepository.findAll();
		return eventos;
	}
	
	@Override
	public void adicionarCategoria(long idEvento, List<Categoria> categorias) {
		Evento evento = eventoRepository.findByIdStartsWithIgnoreCase(idEvento);
		List<Categoria> categoriasEvento = evento.getCategorias();
		
		//validar se categoria ja existe
		
		for (Categoria categoria : categorias) {
			categoriasEvento.add(categoria);
		}
		
		eventoRepository.save(evento);
	}
}
