package uisrael.legalPro;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.service.IUsuarioService;

@SpringBootTest
class LegalProApplicationTests {
	@Autowired
	private IUsuarioService usuarioService;

	@Test
	void contextLoads() {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre_usu("Edison");
		nuevoUsuario.setCorreo_usu("edi@gmail.com");
		nuevoUsuario.setRol("Abogado");
		nuevoUsuario.setTelefono_usu("09343433344");
		nuevoUsuario.setContrasena_usu("ffff");
		usuarioService.guardarUsuario(nuevoUsuario);
		
		List<Usuario> lista = usuarioService.listarUsuarios();
		for (Usuario usuario : lista) {
			System.out.println(usuario.getNombre_usu()+" - "+usuario.getCorreo_usu());
		}
	}

}
