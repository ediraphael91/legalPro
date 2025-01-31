package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uisrael.legalPro.model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
		 
}
