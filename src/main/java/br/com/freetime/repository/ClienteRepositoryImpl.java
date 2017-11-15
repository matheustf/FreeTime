package br.com.freetime.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.freetime.model.Usuario;

@Repository
public class ClienteRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	List<Usuario> buscarClientes() {
		Query query = em.createQuery("select * from Cliente u ");
		
		List<Usuario> clientes = query.getResultList();

		try {
			return clientes;
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Usuarios não foi encontrado");
		}
	}

}
