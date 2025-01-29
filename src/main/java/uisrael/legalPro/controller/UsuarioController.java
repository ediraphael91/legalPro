package uisrael.legalPro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uisrael.legalPro.model.Usuario;
import uisrael.legalPro.service.IUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{IdUsuario}")
    public Optional<Usuario> obtenerUsuario(@PathVariable int IdUsuario) {
        return usuarioService.obtenerUsuarioPorId(IdUsuario);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{IdUsuario}")
    public void eliminarUsuario(@PathVariable int IdUsuario) {
        usuarioService.eliminarUsuario(IdUsuario);
    }

}
