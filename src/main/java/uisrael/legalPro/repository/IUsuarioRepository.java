package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import uisrael.legalPro.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	Optional<Usuario> findByNombre(String nombre);
	Optional<Usuario> findByCorreo(String correo);

}
