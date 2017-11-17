package br.com.freetime.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.freetime.model.Cliente;
import br.com.freetime.repository.custom.UsuarioRepositoryCustom;

@Repository
public class ClienteRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	List<Cliente> buscarClientes() {
		Query query = em.createQuery("select * from Cliente ");
		
		List<Cliente> clientes = query.getResultList();

		try {
			return clientes;
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Clientes não foram encontrados");
		}
	}

}
