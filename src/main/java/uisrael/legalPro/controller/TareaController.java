package uisrael.legalPro.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uisrael.legalPro.model.Tarea;
import uisrael.legalPro.service.ITareaService;

@Controller
public class TareaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ITareaService srvTarea;
	
	public TareaController(ITareaService srvTarea) {
        this.srvTarea = srvTarea;
    }	
	
	@GetMapping("/listartarea")//Direccion de url para ingresar a la pagina
	public String listarTarea(Model model) {
		
		List<Tarea> listaTarea = srvTarea.listarTarea();
		System.out.println("Número de tareas: " + listaTarea.size()); // ← Log
		model.addAttribute("lista", listaTarea);		
		return"/tarea/listaTarea";//direccion donde esta la pagina con el html
	}
	
	@GetMapping("/nuevatarea")
	public String crearTarea(Model model, 
			@RequestParam(value = "idTareaFromListaTarea", required = false) Integer idTarea) {
		
//		LocalDate fechaHoy = LocalDate.now();
		Tarea nueva = new Tarea();
		model.addAttribute("prioridades", Tarea.prioridad.values());
		model.addAttribute("progresos", Tarea.progreso.values());
//		model.addAttribute("fechaActual", fechaHoy.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		model.addAttribute("nuevo", nueva);
		return "/tarea/nuevaTarea";
	}
	
	@PostMapping("/guardartarea")
	public String guardarTarea(@ModelAttribute("nuevo") Tarea nuevo) {
		if(nuevo != null) {		 
		 srvTarea.insertarTarea(nuevo);
		}
		
		return "redirect:/listartarea";
	}
	
	@GetMapping("/actualizartarea/{id_tarea}")
	public String actualizartarea(@PathVariable(value="id_tarea") Integer idTarea, Model model) {
				
		Tarea actualizarTarea = srvTarea.buscarPorId(idTarea);
//		LocalDate fechaAsignadaActual = actualizarTarea.getFechaAsignada();
//		LocalDate fechaLimiteActual = actualizarTarea.getFechaLimite();
		model.addAttribute("prioridades", Tarea.prioridad.values());
		model.addAttribute("progresos", Tarea.progreso.values());
//		model.addAttribute("fechaAsignadaActual", fechaAsignadaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//		model.addAttribute("fechaLimiteActual", fechaLimiteActual);
		model.addAttribute("nuevo",actualizarTarea);
		return"/tarea/nuevaTarea";
	}
	
	@RequestMapping("/eliminartarea/{id_tarea}")
	public String eliminarTarea(@PathVariable(value="id_tarea") Integer idTarea) {
		srvTarea.eliminarTarea(idTarea);
		return "redirect:/listartarea";
	}

}
