package cl.lmedinar.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lmedinar.model.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmail(String email);

}
