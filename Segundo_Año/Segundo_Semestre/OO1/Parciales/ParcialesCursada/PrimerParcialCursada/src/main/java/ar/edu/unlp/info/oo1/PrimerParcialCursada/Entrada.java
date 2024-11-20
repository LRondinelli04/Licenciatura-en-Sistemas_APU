package ar.edu.unlp.info.oo1.PrimerParcialCursada;

import java.time.LocalDate;
import java.time.Period;

public class Entrada {

	private Evento evento;
	private boolean seguro;
	private double precioSeguro;
	private LocalDate fechaCompra;
	
	public Entrada(Evento e, boolean s) {
		this.evento = e;
		this.seguro = s;
		if (s) {
			this.precioSeguro = 500;
		} else {
			this.precioSeguro = 0;
		}
		this.fechaCompra = LocalDate.now();
	}
	
	public double calcularPrecioCompra() {
		return this.evento.precioAsistencia() + this.precioSeguro;
	}
	
	public LocalDate getFechaEvento() {
		return this.evento.fecha;
	}
	
	public double calcularRembolso() {
		double monto = 0;
		int dias = Period.between(LocalDate.now(), this.fechaCompra).getDays();
		if (dias >= 30) {
			monto = this.evento.precioAsistencia() * 0.5;
		} else {
			monto = 0;
		}
		if (this.seguro) {
			monto = monto + (this.evento.precioAsistencia() * 0.15);
		}
		return monto;
	}
	
	public boolean entradaEnFecha(LocalDate fi, LocalDate ff) {
		if (LocalDate.now().isAfter(fi) && LocalDate.now().isBefore(ff)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
