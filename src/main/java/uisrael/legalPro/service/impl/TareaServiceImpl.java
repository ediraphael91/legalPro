package uisrael.legalPro.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import uisrael.legalPro.model.Tarea;
import uisrael.legalPro.repository.ITareaRepository;
import uisrael.legalPro.service.ITareaService;

@Service
public class TareaServiceImpl implements ITareaService{
	
	private final ITareaRepository repo;
	
	public TareaServiceImpl(ITareaRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Tarea> listarTarea() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void insertarTarea(Tarea nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
	}

	@Override
	public void eliminarTarea(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public Tarea buscarPorId(Integer id){
		// TODO Auto-generated method stub
		return repo.buscarPorId(id);
	}

}
