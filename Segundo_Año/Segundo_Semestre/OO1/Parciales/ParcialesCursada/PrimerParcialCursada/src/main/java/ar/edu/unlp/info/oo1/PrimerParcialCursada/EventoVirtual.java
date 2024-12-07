package ar.edu.unlp.info.oo1.ParcialCursada;

import java.time.LocalDate;

public class EventoVirtual extends Evento {

	private double monto;
	
	public EventoVirtual(String n, LocalDate f, String tp, double pi, double pr, double m) {
		super(n, f, tp, pi, pr);
		this.monto = m;
	}

	@Override
	public double precioAsistencia(LocalDate fecha) {
		double precioInscripcion = this.consultaFechaEvento(fecha);			// Consulta la fecha del evento y le sumo el cargo en caso de ser true
		double montoTotal = this.sumaPrecioAsistencia(precioInscripcion) + this.monto;  // Sumo el precioI generado con el precioR y el monto fijo del evento virtual
		return montoTotal;
	}

}
