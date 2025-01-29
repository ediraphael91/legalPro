package uisrael.legalPro.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(nullable = false, length = 50)
	private String nombre;
	@Column(nullable = false, length = 50)
	private String apellido;
	@Column(nullable = false, unique = true, length = 10)
	private String cedula;
	@Column(nullable = false, unique = true, length = 50)
	private String correo;
}
