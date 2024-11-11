package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Servicio {

	protected Mascota mascota;
	protected LocalDate fechaSolicitada;
	
	public Servicio(Mascota mascota, LocalDate fechaSolicitada) {
		this.mascota = mascota;
		this.fechaSolicitada = LocalDate.now();
	}
	
	public LocalDate getFechaSolicitada() {
		return this.fechaSolicitada;
	}
	
	public boolean getFechaAtencion(LocalDate fecha) {
		if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract double costoServicio();
}
