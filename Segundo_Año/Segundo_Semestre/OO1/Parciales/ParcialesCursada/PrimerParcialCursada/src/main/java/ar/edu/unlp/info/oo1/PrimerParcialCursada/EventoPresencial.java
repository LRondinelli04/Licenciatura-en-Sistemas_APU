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

	@Override
	public double precioAsistencia(LocalDate fecha) {
		double montoTotal = this.sumaPrecioAsistencia();
		double precioSedes = this.sedes.stream()
							.mapToDouble(s -> s.calcPrecioSede())
							.sum();
		montoTotal += precioSedes;
		montoTotal = this.consultaFechaEvento(fecha, montoTotal);
		return montoTotal;
	}

}
