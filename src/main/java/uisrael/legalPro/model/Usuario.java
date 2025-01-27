package uisrael.legalPro.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Usuario  {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String cedula;
	private String profesion;
	private String correo;
	private String rol;
	private boolean estado;
}
