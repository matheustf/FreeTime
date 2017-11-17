package br.com.freetime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.freetime.model.Usuario;
import br.com.freetime.repository.custom.UsuarioRepositoryCustom;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>,UsuarioRepositoryCustom {

	List<Usuario> findByNameStartsWithIgnoreCase(String name);
	
	Usuario findByLoginStartsWithIgnoreCase(String login);

	void delete(Usuario usuario);

	List<Usuario> buscarUsuarios();
	
}
