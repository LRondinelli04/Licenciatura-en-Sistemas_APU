package ar.edu.unlp.info.oo1.Ej17_AlquilerDePropiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	
	private Propiedad propiedad;
	private LocalDate fechaInicioReserva, fechaFinReserva;
	
	public Reserva(Propiedad propiedad, LocalDate fechaInicioReserva, LocalDate fechaFinReserva) {
		this.propiedad = propiedad;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public LocalDate getFechaInicioReserva() {
		return this.fechaInicioReserva;
	}
	
	public LocalDate getFechaFinReserva() {
		return this.fechaFinReserva;
	}
	
	public double calcularPrecioReserva() {
		double monto = 0;
		long dias = ChronoUnit.DAYS.between(fechaInicioReserva, fechaFinReserva);
		monto = this.propiedad.getPrecioPorNoche() * dias;
		return monto;
	}
}
