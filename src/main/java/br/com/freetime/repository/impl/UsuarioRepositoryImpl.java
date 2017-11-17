package br.com.freetime.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.freetime.model.Usuario;
import br.com.freetime.repository.custom.UsuarioRepositoryCustom;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	List<Usuario> buscarUsuarios() {
		Query query = em.createQuery("select u.login from Usuario u ");
		
		List<Usuario> usuarios = query.getResultList();

		try {
			return usuarios;
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Usuarios não foram encontrados");
		}
	}

}
