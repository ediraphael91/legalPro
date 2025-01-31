package uisrael.legalPro.service;

import uisrael.legalPro.model.Usuario;
import java.util.List;

public interface IUsuarioService {
	
	public void insertarUsuario(Usuario usuarioNuevo);	
	public List<Usuario> listarUsuario();	
	public Usuario buscarUsuarioId(int idUsuario);
	public void eliminarUsuarioId(int idUsuario);

}
