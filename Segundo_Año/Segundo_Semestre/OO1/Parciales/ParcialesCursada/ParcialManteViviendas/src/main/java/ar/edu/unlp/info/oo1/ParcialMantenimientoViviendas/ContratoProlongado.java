package Segundo_Año.Segundo_Semestre.OO1.Parciales.ParcialesCursada.ParcialManteViviendas.src.main.java.ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import java.time.LocalDate;

public class ContratoProlongado extends Contrato {

	private int cantDias;
	
	public ContratoProlongado(Servicio s, Cliente c, LocalDate f, int cd) {
		super(s, c, f);
		this.cantDias = cd;
	}

	@Override
	public double montoAPagar() {
		double montoServ = this.servicio.montoServicio() * this.cantDias;
		if (this.cantDias > 5) {
			montoServ -= montoServ * 0.1;
		}
		return montoServ;
	}

}
