package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uisrael.legalPro.model.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea, Integer>{
	
	@Query("select t from Tarea t where t.id_tarea=?1")
	public Tarea buscarPorId(Integer id);
}
