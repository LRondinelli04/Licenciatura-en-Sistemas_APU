package ar.edu.unlp.info.oo1.ParcialCursada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoPresencial extends Evento {

	private List<Sede> sedes;
	
	public EventoPresencial(String n, LocalDate f, String tp, double pi, double pr) {
		super(n, f, tp, pi, pr);
		this.sedes = new ArrayList<Sede>();
	}

	public void addSede(Sede s) {
		this.sedes.add(s);
	}

	@Override
	public double precioAsistencia(LocalDate fecha) {
		double precioInscripcion = this.consultaFechaEvento(fecha); 		// Consulta la fecha del evento y le sumo el cargo en caso de ser true
		double montoTotal = this.sumaPrecioAsistencia(precioInscripcion); 	// Sumo el precioI generado y el precioR
		double precioSedes = this.sedes.stream()				// precio de las sedes
							.mapToDouble(s -> s.calcPrecioSede())
							.sum();
		montoTotal += precioSedes;						// Sumo el precio de las sedes con el monto generado
		return montoTotal;
	}

}
