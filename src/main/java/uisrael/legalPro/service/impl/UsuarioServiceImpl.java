package uisrael.legalPro.service.impl;
import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.repository.IUsuarioRepository;
import uisrael.legalPro.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	private final IUsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

	@Override
	public List<Usuario> listarUsuarios() {
		  return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorId(int IdUsuario) {
		return usuarioRepository.findById(IdUsuario);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(int IdUsuario) {
		usuarioRepository.deleteById(IdUsuario);		
	}

}
