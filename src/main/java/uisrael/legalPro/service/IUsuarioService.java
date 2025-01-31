package uisrael.legalPro.service;

import uisrael.legalPro.model.Usuario;
import java.util.List;

public interface IUsuarioService {
	
	List<Usuario> listarUsuarios();
	public Usuario buscarPorId(Integer id);
    Usuario guardarUsuario(Usuario usuario);
    void eliminarUsuario(int IdUsuario);
    Usuario findByCorreo(String correo);   
}
