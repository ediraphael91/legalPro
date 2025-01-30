package uisrael.legalPro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;

	@Column(nullable = false, length = 50)
	private String nombre_usu;

	@Column(nullable = false, unique = true, length = 50)
	private String correo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Rol rol;

	// Definición del Enum Rol
	public enum Rol {
		Admin,
		Abogado,
		Asistente,
		Consultor_Legal,
		Especialista_Legal,
		Gerente_Legal,
		Pasante,
		Paralegal		
	}

	@Column(nullable = false, length = 15)
	private String telefono;

	@Column(nullable = false)
	private String contrasena_usu;

	@OneToMany(mappedBy = "fkUsuario")
	private List<Tarea> listaTarea = new ArrayList<>();

	// Método adicional para aceptar String y convertirlo en Enum Rol
	public void setRol(String rolString) {
		try {
			this.rol = Rol.valueOf(rolString); // Convierte el String a Enum
		} catch (IllegalArgumentException e) {
			System.out.println("Error: El rol '" + rolString + "' no es válido.");
		}
	}
}
