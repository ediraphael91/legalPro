package uisrael.legalPro.service;

import uisrael.legalPro.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
	
	List<Usuario> listarUsuarios();
    Optional<Usuario> obtenerUsuarioPorId(int IdUsuario);
    Usuario guardarUsuario(Usuario usuario);
    void eliminarUsuario(int IdUsuario);

}
