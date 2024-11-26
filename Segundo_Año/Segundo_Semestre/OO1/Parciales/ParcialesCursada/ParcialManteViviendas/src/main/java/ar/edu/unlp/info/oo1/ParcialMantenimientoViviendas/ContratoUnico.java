package ar.edu.unlp.info.oo1.ParcialMantenimientoViviendas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ContratoUnico extends Contrato {

	public ContratoUnico(Servicio s, Cliente c, LocalDate f) {
		super(s, c, f);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double montoAPagar() {
		double montoServ = this.servicio.montoServicio();
		if (this.contratoFinde(this.fecha)) {
			montoServ += montoServ * 0.15;
		}
		return montoServ;
	}
	
	public boolean contratoFinde(LocalDate fecha) {
		DayOfWeek dia = DayOfWeek.from(fecha);
		if (dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}

}
