package uisrael.legalPro.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uisrael.legalPro.model.Cliente;
import uisrael.legalPro.service.IClienteService;

@Controller
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	@Autowired
	private IClienteService servicioCliente;
	private static final long serialVersionUID = 1L;
	
	@GetMapping("cliente")//Direccion de url para ingresar a la pagina
	public String abrirUsuario(Model model) {
		
		List<Cliente> listaClienteBD=servicioCliente.listarCliente();
		model.addAttribute("datosUsuario", listaClienteBD);		
		return"/cliente/registroCliente";//direccion donde esta la pagina con el html
	}
	
	@GetMapping("/nuevocliente")
	public String crearCliente(Model model){
		model.addAttribute("nuevo", new Cliente());
		return"/cliente/nuevoCliente";
	}
	
	@PostMapping("/guardarcli")
	public String guardarCliente(@ModelAttribute("nuevo") Cliente nuevoCliente) {
		servicioCliente.insertaCliente(nuevoCliente);
		
		return"redirect:/cliente";
	}

}
