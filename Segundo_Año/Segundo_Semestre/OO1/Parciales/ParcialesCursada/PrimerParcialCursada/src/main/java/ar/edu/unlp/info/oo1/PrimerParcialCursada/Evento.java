package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public abstract class Evento {
	
	protected String nombre, temaP;
	protected LocalDate fecha;
	protected double precioI, precioR;
	
	public Evento(String n, LocalDate f, String tp, double pi, double pr) {
		this.nombre = n;
		this.fecha = f;
		this.temaP = tp;
		this.precioI = pi;
		this.precioR = pr;
	}
	
	public double fechaConsulta(double monto) {
		if (this.fecha.equals(LocalDate.now())) {
			monto = monto + (monto * 0.2);
		}
		return monto;
	}
	
	public abstract double precioAsistencia();
	

}
