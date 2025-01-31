package uisrael.legalPro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uisrael.legalPro.model.Cliente;
import uisrael.legalPro.repository.IClienteRepository;
import uisrael.legalPro.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private final IClienteRepository repo;
	
	public ClienteServiceImpl(IClienteRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.buscarPorCorreo(username)
			.map(user -> 
				org.springframework.security.core.userdetails.User.builder()
				.username(user.getNombre_cli())
				.password(user.getContrasena_cli())
				.roles("CLIENTE") // Debe coincidir con hasRole("CLIENTE")
				.build()					
			)
			.orElseThrow(() -> new UsernameNotFoundException("Cliente no encontrado: " + username));			
	}

	@Override
	public void insertaCliente(Cliente clienteNuevo) {
		try {
			repo.save(clienteNuevo);
		} catch (Exception e) {
			System.out.println("erro:"+ e.getMessage());
		}
		
	}

	@Override
	public List<Cliente> listarCliente() {
		return repo.findAll();
	}

}
