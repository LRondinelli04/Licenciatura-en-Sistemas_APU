package ar.edu.unlp.info.oo1.ParcialCursada;

import java.time.LocalDate;

public abstract class Evento {

	protected String nombre, temaP;
	protected LocalDate fechaEvento;
	protected double precioI, precioR;
	
	public Evento(String n, LocalDate f, String tp, double pi, double pr) {
		this.nombre = n;
		this.fechaEvento = f;
		this.temaP = tp;
		this.precioI = pi;
		this.precioR = pr;
	}
	
	public abstract double precioAsistencia(LocalDate fecha);
	
	public double consultaFechaEvento(LocalDate fecha) {
		if (fecha.equals(this.fechaEvento)) {
			return this.precioI * 0.2;
		} else {
			return this.precioI;
		}
	}
	
	public double sumaPrecioAsistencia(double precioInscripcion) {
		return precioInscripcion + this.precioR;
	}
	
}
