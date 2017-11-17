package br.com.freetime.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.freetime.exception.CampoObrigatorioException;
import br.com.freetime.exception.EnderecoException;
import br.com.freetime.model.Categoria;
import br.com.freetime.model.Evento;
import br.com.freetime.service.impl.EventoServiceImpl;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoServiceImpl eventoService;

	private final Logger logger = Logger.getLogger(EventoServiceImpl.class);

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Evento>> buscar() throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest buscar eventos");
		// Util.validar(endereco.getCep());
		List<Evento> eventos = eventoService.buscarEventos();

		return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Evento> incluir(@RequestBody @Valid Evento evento, BindingResult bindingResult)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest incluir evento");
		if (bindingResult.hasErrors()) {
			throw new CampoObrigatorioException(bindingResult);
		}
		// Util.validar(endereco.getCep());
		eventoService.incluir(evento);
		return new ResponseEntity<Evento>(HttpStatus.OK);
	}

	@DeleteMapping("/{idEvento}")
	@ResponseBody
	public ResponseEntity<Evento> deletar(@PathParam("idEvento") long idEvento)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest deletar evento");

		eventoService.deletar(idEvento);
		return new ResponseEntity<Evento>(HttpStatus.OK);
	}

	@PutMapping("/{idEvento}")
	@ResponseBody
	public ResponseEntity<Evento> atualizar(@PathParam("idEvento") long idEvento, @RequestBody @Valid Evento evento, BindingResult bindingResult)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest atualizar evento");
		if (bindingResult.hasErrors()) {
			throw new CampoObrigatorioException(bindingResult);
		}
		// Util.validar(endereco.getCep());

		eventoService.atualizar(idEvento, evento);
		return new ResponseEntity<Evento>(HttpStatus.OK);
	}
	
	@PostMapping("{idEvento}/categorias")
	@ResponseBody
	public void inserirCategoria(@PathParam("idEvento") long idEvento, @RequestParam("login") List<Categoria> categorias) {
		eventoService.adicionarCategoria(idEvento, categorias);
	}

}
