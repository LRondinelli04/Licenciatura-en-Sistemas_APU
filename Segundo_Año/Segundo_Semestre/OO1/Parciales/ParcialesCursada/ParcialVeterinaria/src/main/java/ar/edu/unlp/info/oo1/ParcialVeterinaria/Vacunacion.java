package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;

public class Vacunacion extends Servicio {
	
	private Medico medico;
	private String nombreVacuna;
	private double costo;
	private boolean materiales;
	
	public Vacunacion(Medico medico, Mascota mascota, String nv, double c, boolean m) {
		super(LocalDate.now(), mascota);
		this.medico = medico;
		this.nombreVacuna = nv;
		this.costo = c;
		this.materiales = m;
	}

	@Override
	public double montoRecaudacion() {
		double monto = this.medico.getHonorarios() + this.costo;
		if (this.materiales) {
			monto += 500;
		}
		if (this.atencionDomingo()) {
			monto += 200;
		}
		return monto;
	}

}
