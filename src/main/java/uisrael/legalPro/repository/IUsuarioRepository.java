package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uisrael.legalPro.model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	@Query("select u from Usuario u where u.id_usuario=?1")
	public Usuario buscarPorId(Integer id);
	
	@Query("select u from Usuario u where u.correo_usu=?1")
	public Usuario findByCorreo(String correo); 
}
