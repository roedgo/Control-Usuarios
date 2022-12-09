package com.gestionusuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestionusuarios.entidades.Usuario;
import com.gestionusuarios.servicio.UsuarioServicio;

//@SuppressWarnings("unused")
@Controller
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		List<Usuario> listaUsuarios = usuarioServicio.listAll();
				modelo.addAttribute("listaUsuarios" , listaUsuarios);
		//modelo.addAttribute("palabraClave" , palabraClave);
		return "index";
	}
	
	@RequestMapping("/nuevo")
	public String mostrarFormularioDeRegistrarUsuario(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		return "nuevo_usuario";
	}
	
	@RequestMapping(value= "/guardar", method=RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServicio.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarUsuario(@PathVariable(name="id")Long id) {
		ModelAndView modelo= new ModelAndView("editar_usuario");
		Usuario usuario= usuarioServicio.get(id);
		modelo.addObject("usuario",usuario);
		return modelo;
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable( name="id") Long id) {
		usuarioServicio.delete(id);
		return "redirect:/";
	}
	
	
}
