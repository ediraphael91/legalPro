package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uisrael.legalPro.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
