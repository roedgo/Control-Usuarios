package com.gestionusuarios.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionusuarios.entidades.Usuario;
import com.gestionusuarios.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> listAll(){
		//if(palabraClave != null) {
		//return usuarioRepositorio.findAll(palabraClave);
		//}
		return usuarioRepositorio.findAll();
	}
	public void save(Usuario usuario) {
		usuarioRepositorio.save(usuario);
		
	}
    public Usuario get(Long id) {
		return usuarioRepositorio.findById(id).get();
	}
    public void delete(Long id) {
    	usuarioRepositorio.deleteById(id);
    }
}
