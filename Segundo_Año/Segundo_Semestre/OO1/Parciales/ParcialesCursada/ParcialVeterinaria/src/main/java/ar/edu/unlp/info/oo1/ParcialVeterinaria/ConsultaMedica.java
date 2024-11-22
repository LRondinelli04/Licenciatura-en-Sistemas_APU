package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;

public class ConsultaMedica extends Servicio {

	private Medico medico;
	private boolean materiales;
	
	public ConsultaMedica(Medico medico, Mascota mascota, boolean m) {
		super(LocalDate.now(), mascota);
		this.medico = medico;
		this.materiales = m;
	}

	@Override
	public double montoRecaudacion() {
		double monto = this.medico.getHonorarios() + (100 * this.medico.getAntiguedad());
		if (this.materiales) {
			monto += 300;
		}
		if (this.atencionDomingo()) {
			monto += 200;
		}
		return monto;
	}
	
}
