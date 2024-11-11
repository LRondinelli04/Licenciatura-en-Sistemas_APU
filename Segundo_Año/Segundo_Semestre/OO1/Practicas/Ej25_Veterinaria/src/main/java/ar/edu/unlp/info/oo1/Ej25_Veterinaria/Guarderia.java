package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.LocalDate;

public class Guarderia extends Servicio {

	private int cantDias;
	
	public Guarderia(Mascota mascota, int cantDias) {
		super(mascota, LocalDate.now());
		this.cantDias = cantDias;
	}

	@Override
	public double costoServicio() {
		double total = 500;
		if (this.mascota.getServicios().size() > 5) {
			total -= total * 0.1;
		}
		return total;
	}

}
