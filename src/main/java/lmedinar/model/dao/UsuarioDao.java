package lmedinar.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lmedinar.model.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}
