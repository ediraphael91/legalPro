package uisrael.legalPro.service.impl;
import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.repository.IUsuarioRepository;
import uisrael.legalPro.service.IUsuarioService;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioRepository repoUsuario;

	@Override
	public void insertarUsuario(Usuario usuarioNuevo) {
		try {
			repoUsuario.save(usuarioNuevo);
		} catch (Exception e) {
			System.out.println("erro:"+ e.getMessage());
		}		
	}

	@Override
	public List<Usuario> listarUsuario() {
		return repoUsuario.findAll();
	}

	@Override
	public Usuario buscarUsuarioId(int idUsuario) {
		return repoUsuario.findById(idUsuario).get();
	}

	@Override
	public void eliminarUsuarioId(int idUsuario) {
		repoUsuario.deleteById(idUsuario);

 }

}
