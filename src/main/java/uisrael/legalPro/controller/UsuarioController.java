package uisrael.legalPro.controller;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.service.IUsuarioService;


@Controller
public class UsuarioController implements Serializable {
	/**
	 * 
	 */
	@Autowired
	private IUsuarioService servicioUsuario;
	private static final long serialVersionUID = 1L;
	

	@GetMapping("listausuario")//Direccion de url para ingresar a la pagina
	public String abrirUsuario(Model model) {
		
		List<Usuario> listaUsuarioBD=servicioUsuario.listarUsuario();
		model.addAttribute("datosUsuario", listaUsuarioBD);		
		return"/usuario/listaUsuario";//direccion donde esta la pagina con el html
	}
	
	@GetMapping("/nuevousuario")
	public String crearUsuario(Model model){
		model.addAttribute("nuevo", new Usuario());
		return"/usuario/nuevoUsuario";
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute("nuevo") Usuario nuevoUsuario) {
		servicioUsuario.insertarUsuario(nuevoUsuario);
		return"redirect:/listausuario";
	}
	
	@GetMapping("/actualizarusuario/{idUsuario}")
	public String actualizarusuario(@PathVariable(value="idUsuario") int idUsuario, Model model) {
		Usuario actualizarUsuario=servicioUsuario.buscarUsuarioId(idUsuario);
		model.addAttribute("nuevo",actualizarUsuario);
		return"/usuario/nuevoUsuario";
	}
	
	@RequestMapping("/eliminarusuario/{idUsuario}")
	public String eliminarUsuario(@PathVariable(value="idUsuario") int idUsuario) {
		servicioUsuario.eliminarUsuarioId(idUsuario);
		return "redirect:/listausuario";
	}
 

   

}
