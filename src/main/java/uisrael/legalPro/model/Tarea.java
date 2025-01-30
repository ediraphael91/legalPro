package uisrael.legalPro.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Tarea implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id_tarea;
	private String titulo;
	@Column(name = "fechaAsignada")
	private LocalDate fechaAsignada;
	@Column(name = "fechaLimite")
	private LocalDate fechaLimite;
	@Enumerated(EnumType.STRING)
	private prioridad prioridad;
	public enum prioridad{
		Baja,
		Media,
		Alta
	}
	@Enumerated(EnumType.STRING)
	private progreso pogreso;
	public enum progreso{
		Iniciado,
		En_Proceso,
		Cerrado
	}
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario fkUsuario;
	
	
	@ManyToOne
	@JoinColumn(name = "id_caso")
	private Caso fkCaso;

}
