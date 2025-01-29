package uisrael.legalPro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	private String combre_cli;
	private String correo_cli;
	private String telefono_cli;
	private String cedula_cli;
	private String contrasena_cli;
	
	@OneToMany(mappedBy = "fkCliente")
	private List<Caso> listaCaso = new ArrayList<>();

}
