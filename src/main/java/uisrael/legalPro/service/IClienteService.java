package uisrael.legalPro.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import uisrael.legalPro.model.Cliente;

public interface IClienteService extends UserDetailsService {
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public void insertaCliente(Cliente clienteNuevo);
	public List<Cliente> listarCliente();
	
}
