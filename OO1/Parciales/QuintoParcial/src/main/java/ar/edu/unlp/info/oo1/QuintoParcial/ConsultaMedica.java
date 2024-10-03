package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class ConsultaMedica implements Servicio {

	private Medico medico;
	private Mascota mascota;
	private int materialesDescartables;
	private LocalDate fechaAtencion;
	
	public ConsultaMedica(Mascota mascota, Medico medico, int materialesDescartables) {
		this.medico = medico;
	    this.mascota = mascota;
		this.materialesDescartables = materialesDescartables;
		this.fechaAtencion = LocalDate.now();
	}

	@Override
	public double costoServicio() {
		double total = 0.0;
		double honorarios = this.medico.getHonorarios();
		double antiguedad = this.medico.getAntiguedad() * 100;
		total = honorarios + antiguedad + (this.materialesDescartables * 300);
		if (this.atencionDomingo()) {
			total += 200;
		}
		return total;
	}
	
	public boolean atencionDomingo() {
		if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public LocalDate getFecha() {
		return this.fechaAtencion;
	}
	
}
