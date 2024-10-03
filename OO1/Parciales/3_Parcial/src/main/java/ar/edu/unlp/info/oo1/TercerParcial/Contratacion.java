package ar.edu.unlp.info.oo1.TercerParcial;

import java.time.LocalDate;

public class Contratacion {

	protected Cliente cliente;
	protected Servicio servicio;
	protected LocalDate fecha;
	
	public Contratacion(Cliente cliente, Servicio servicio, LocalDate fecha) {
		this.cliente = cliente;
		this.servicio = servicio;
		this.fecha = fecha;
	}
	
	public double obtenerMonto() {
		double monto = this.servicio.calcularMonto();
		
		if (this.isFinde()) {
			monto += (this.servicio.calcularMonto() * 0.15);
		}
		
		return monto;
	}
	
	public boolean isFinde() {
		return fecha.getDayOfWeek().equals(java.time.DayOfWeek.SATURDAY) || fecha.getDayOfWeek().equals(java.time.DayOfWeek.SUNDAY);
	}
	
	
	
}
