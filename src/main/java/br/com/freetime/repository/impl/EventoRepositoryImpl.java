package br.com.freetime.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.freetime.model.Evento;
import br.com.freetime.model.Usuario;
import br.com.freetime.repository.custom.EventoRepositoryCustom;

@Repository
public class EventoRepositoryImpl implements EventoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	List<Evento> buscarClientes() {
		Query query = em.createQuery("select * from Evento ");
		
		List<Evento> eventos = query.getResultList();

		try {
			return eventos;
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Eventos não foram encontrados");
		}
	}

}
