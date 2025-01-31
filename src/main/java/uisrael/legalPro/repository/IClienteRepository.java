package uisrael.legalPro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uisrael.legalPro.model.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
			
	@Query("select c from Cliente c where c.correo_cli=?1")
	public Optional<Cliente> buscarPorCorreo(String correo);
	
}
