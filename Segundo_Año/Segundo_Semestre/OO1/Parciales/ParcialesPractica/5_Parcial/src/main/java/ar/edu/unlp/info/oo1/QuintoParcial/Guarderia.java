package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.LocalDate;
import java.util.List;

public class Guarderia implements Servicio {

	private Mascota mascota;
	private int cantDias;
	private LocalDate fecha;
	
	public Guarderia(Mascota mascota, int cantDias) {
	    this.mascota = mascota;
		this.cantDias = cantDias;
		this.fecha = LocalDate.now();
	}

	@Override
	public double costoServicio() {
		double total = 0.0;
		total = this.cantDias * 500;
		if (this.mascota.getServicios() >= 5) {
			total *= 0.10;
		}
		return total;
	}

	@Override
	public LocalDate getFecha() {
		return this.fecha;
	}
	
}
