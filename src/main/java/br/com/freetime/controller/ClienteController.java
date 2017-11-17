package br.com.freetime.controller;

import java.util.List;

import javax.validation.Valid;

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
import br.com.freetime.model.Cliente;
import br.com.freetime.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteService;

	private final Logger logger = Logger.getLogger(ClienteServiceImpl.class);

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> buscar() throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest buscar clientes");
		// Util.validar(endereco.getCep());
		List<Cliente> clientes = clienteService.buscarClientes();

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Cliente> incluir(@RequestBody @Valid Cliente cliente, BindingResult bindingResult)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest incluir cliente");
		if (bindingResult.hasErrors()) {
			throw new CampoObrigatorioException(bindingResult);
		}
		// Util.validar(endereco.getCep());
		clienteService.incluir(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

	@DeleteMapping("/{login}")
	@ResponseBody
	public ResponseEntity<Cliente> deletar(@RequestParam("login") long id)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest deletar cliente");

		clienteService.deletar(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

	@PutMapping("/{login}")
	@ResponseBody
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente, BindingResult bindingResult)
			throws EnderecoException, CampoObrigatorioException {
		logger.info("Rest atualizar cliente");
		if (bindingResult.hasErrors()) {
			throw new CampoObrigatorioException(bindingResult);
		}
		// Util.validar(endereco.getCep());

		clienteService.atualizar(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
