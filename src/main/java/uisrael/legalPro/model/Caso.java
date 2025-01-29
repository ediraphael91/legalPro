package uisrael.legalPro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Caso implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id_caso;
	@Enumerated(EnumType.STRING)
	private tipoCaso tipoCaso;
	public enum tipoCaso{
		Penal,
		Civil,
		Laboral,
		Familiar,
		Mercantíl,
		Administrativo,
		Fiscal,
		Propiedad_Intelectual,
		Inmobiliario,
		Internacional
	}
	@Column(name="fechaInicio")
	private LocalDate fechaInicio;
	@Column(name="fechaFin")
	private LocalDate fechaFin;
	@Enumerated(EnumType.STRING)
	private estado estado;
	public enum estado{
		Ingresado,
		En_Revisión,
		Finalizado		
	}
	private String descripcion;
	
	@ManyToOne
	private Cliente fkCliente;
	
	@OneToMany(mappedBy = "fkCaso")
	private List<Tarea> listaTarea = new ArrayList<>();
	
	@OneToMany(mappedBy = "fkCaso")
	private List<Plazo> listaPlazo = new ArrayList<>();

}
