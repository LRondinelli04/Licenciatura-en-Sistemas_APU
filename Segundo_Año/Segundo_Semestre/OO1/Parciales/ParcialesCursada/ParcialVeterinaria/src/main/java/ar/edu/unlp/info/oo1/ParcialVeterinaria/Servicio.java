package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Servicio {

	protected LocalDate fecha;
	protected Mascota mascota;
	
	public Servicio(LocalDate f, Mascota m) {
		this.fecha = f;
		this.mascota = m;
	}
	
	public abstract double montoRecaudacion();
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public boolean atencionDomingo() {
		if (this.fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}
	
}
