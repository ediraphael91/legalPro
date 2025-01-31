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

import uisrael.legalPro.model.Plazo;
import uisrael.legalPro.service.IPlazoService;

@Controller
public class PlazoController implements Serializable{
	
	@Autowired
    private IPlazoService servicioPlazo;

    private static final long serialVersionUID = 1L;

    // Listar todos los plazos
    @GetMapping("/listaPlazos")
    public String listarPlazos(Model model) {
        List<Plazo> listaPlazosBD = servicioPlazo.getAllPlazos();
        model.addAttribute("datosPlazo", listaPlazosBD);
        return "plazo/listaPlazos"; // Página que muestra la lista de plazos
    }

    // Crear un nuevo plazo
    @GetMapping("/nuevoplazo")
    public String crearPlazo(Model model) {
        model.addAttribute("plazo", new Plazo());
        return "plazo/nuevoPlazo"; // Página para crear un nuevo plazo
    }

    // Guardar un nuevo plazo
    @PostMapping("/guardarplazo")
    public String guardarPlazo(@ModelAttribute("nuevo") Plazo nuevoPlazo) {
        servicioPlazo.savePlazo(nuevoPlazo);
        return "redirect:/listaPlazos"; // Redirige a la lista de plazos después de guardar
    }

    // Actualizar un plazo existente
    @GetMapping("/actualizarplazo/{id_plazo}")
    public String actualizarplazo(@PathVariable(value = "id_plazo") Integer id_plazo, Model model) {
        Plazo plazoActualizar = servicioPlazo.getPlazoById(id_plazo).orElse(null);
        if (plazoActualizar != null) {
            model.addAttribute("nuevo", plazoActualizar);
            return "plazo/nuevoPlazo"; // Página para editar un plazo
        }
        return "redirect:/listaPlazos"; // Si no encuentra el plazo, redirige a la lista
    }

    // Eliminar un plazo por ID
    @RequestMapping("/eliminarplazo/{id_plazo}")
    public String eliminarPlazo(@PathVariable(value = "id_plazo") Integer idPlazo) {
        servicioPlazo.deletePlazo(idPlazo);
        return "redirect:/listaPlazos"; // Redirige a la lista de plazos después de eliminar
    }

    // Filtrar plazos por criticidad
    @GetMapping("/plazosporcriticidad/{criticidad}")
    public String plazosPorCriticidad(@PathVariable(value = "criticidad") String criticidad, Model model) {
        List<Plazo> plazosFiltrados = servicioPlazo.getPlazosByCriticidad(criticidad);
        model.addAttribute("datosPlazos", plazosFiltrados);
        return "plazo/listaPlazos"; // Muestra la lista filtrada de plazos
    }

}
