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
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Plazo implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id_plazo;
	@Enumerated(EnumType.STRING)
	private tipoEvento tipoEvento;
	public enum tipoEvento{
		Presentación_demanda,
		Notificación_al_demandado,
		Audiencia_preliminar,
		Presentación_de_pruebas,
		Citación_de_testigos,
		Audiencia_principal,
		Sentencia,
		Apelación,
		Mediación_o_conciliación,
		Prescripción,
		Vencimiento_de_contrato,
		Pago_de_honorarios,
		Reunión_con_el_cliente,
		Solicitud_de_prórroga,
		Cierre_del_caso
	}
	@Column(name = "fechaAudiencia")
	private LocalDate fechaAudiencia;
	@Column(name = "vencimiento_contrato")
	private LocalDate vencimiento_contrato;
	@Enumerated(EnumType.STRING)
	private criticidad criticidad;
	public enum criticidad{
		Alta,
		Baja,
		Media
	}
	
	@ManyToOne
	private Caso fkCaso;

}
