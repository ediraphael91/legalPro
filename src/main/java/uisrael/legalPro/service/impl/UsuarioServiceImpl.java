package uisrael.legalPro.service.impl;
import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.repository.IUsuarioRepository;
import uisrael.legalPro.service.IUsuarioService;

import org.springframework.stereotype.Service;

import java.util.List;

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
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(int IdUsuario) {
		usuarioRepository.deleteById(IdUsuario);		
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.buscarPorId(id);
	}

	@Override
	public Usuario findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByCorreo(correo);
	}	

}
