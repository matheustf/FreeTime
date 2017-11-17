package br.com.freetime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.freetime.model.Cliente;
import br.com.freetime.repository.custom.ClienteRepositoryCustom;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom{

	Cliente findByIdStartsWithIgnoreCase(long id);

	List<Cliente> buscarClientes();

}
