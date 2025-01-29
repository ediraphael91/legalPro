package uisrael.legalPro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@Column(nullable = false, length = 50)
	private String nombre_usu;
	@Column(nullable = false, unique = true, length = 50)
	private String correo;
	@Enumerated(EnumType.STRING)
	private rol rol;
	public enum rol{
		Admin,
		Abogado,
		Asistente,
		Consultor_Legal,
		Especialista_Legal,
		Gerente_Legal,
		Pasante,
		Paralegal		
	}
	private String telefono;
	private String contrasena_usu;
	
	@OneToMany(mappedBy = "fkUsuario")
	private List<Tarea> listaTarea = new ArrayList<>();
}
