package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;

public class Guarderia extends Servicio {

	private int cantDias;
	
	public Guarderia(int cd, Mascota m) {
		super(LocalDate.now(), m);
		this.cantDias = cd;
	}

	@Override
	public double montoRecaudacion() {
		double monto = 500 * this.cantDias;
		if (this.mascota.getServicios().size() >= 5) {
			monto -= monto * 0.1;
		}
		return monto;
	}

}
