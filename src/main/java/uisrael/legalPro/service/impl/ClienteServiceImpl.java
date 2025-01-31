package uisrael.legalPro.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uisrael.legalPro.repository.IClienteRepository;
import uisrael.legalPro.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
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

}
