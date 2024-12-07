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
		double precioInscripcion = this.consultaFechaEvento(fecha);
		double montoTotal = this.sumaPrecioAsistencia(precioInscripcion) + this.monto;
		return montoTotal;
	}

}
