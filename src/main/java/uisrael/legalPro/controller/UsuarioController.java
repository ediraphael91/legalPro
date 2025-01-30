package uisrael.legalPro.controller;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
 

   

}
