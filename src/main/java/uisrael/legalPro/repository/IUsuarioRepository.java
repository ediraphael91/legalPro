package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.legalPro.model.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	
}
