package ar.edu.unlp.info.oo1.ParcialCursada;

import java.time.LocalDate;
import java.time.Period;

public class Entrada {

	private Usuario usuario;
	private Evento evento;
	private boolean seguro;
	private double precioSeguro;
	private LocalDate fechaCompra;
	
	public Entrada(Usuario u, Evento e, boolean s) {
		this.usuario = u;
		this.evento = e;
		if (s) {
			this.precioSeguro = 500;
		} else {
			this.precioSeguro = 0;
		}
		this.fechaCompra = LocalDate.now();
	}
	
	public LocalDate getFechaCompra() {
		return this.fechaCompra;
	}
	
	public Evento getEvento() {
		return this.evento;
	}
	
	public double getPrecioSeguro() {
		return this.precioSeguro;
	}
	
	public double montoARecuperar() {
		double monto = 0;
		int dias = Period.between(fechaCompra, this.evento.fechaEvento).getDays();
		if (dias >= 30) {
			monto = this.evento.precioAsistencia(fechaCompra) * 0.5;
		} else {
			monto = 0;
		}
		if (this.seguro) {
			monto += this.evento.precioAsistencia(fechaCompra) * 0.15;
		}
		return monto;
	}
	
}
