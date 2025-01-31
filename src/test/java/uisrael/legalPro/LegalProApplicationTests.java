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
		nuevoUsuario.setContrasena_usu("edi@gmail.com");
		nuevoUsuario.setRol_usu(null);
		nuevoUsuario.setTelefono("09343433344");
		nuevoUsuario.setContrasena_usu("edi123");
		usuarioService.insertarUsuario(nuevoUsuario);
		
		List<Usuario> lista = usuarioService.listarUsuario();
		for (Usuario usuario : lista) {
			System.out.println(usuario.getNombre_usu()+" - "+usuario.getContrasena_usu());
		}
	}

}
