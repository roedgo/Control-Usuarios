package com.gestionusuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionusuarios.entidades.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	//@Query("SELECT p FROM usuario p WHERE p.nombre LIKE %?1%" + "OR p.apellido LIKE %?1%" + "OR p.nacionalidad LIKE %?1%")
	//public List<Usuario> findAll(String palabraClave);
	
	
}
