package br.com.freetime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.freetime.model.Evento;
import br.com.freetime.repository.custom.EventoRepositoryCustom;

public interface EventoRepository extends JpaRepository<Evento, Long>, EventoRepositoryCustom{

	Evento findByIdStartsWithIgnoreCase(long id);

	List<Evento> buscarClientes();

}
