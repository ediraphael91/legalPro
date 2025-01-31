package uisrael.legalPro.service;

import java.util.List;
import uisrael.legalPro.model.Tarea;

public interface ITareaService {
	
	public List<Tarea> listarTarea();
	public void insertarTarea(Tarea nuevo);
	public void eliminarTarea(Integer id);
	public Tarea buscarPorId(Integer id);
}
