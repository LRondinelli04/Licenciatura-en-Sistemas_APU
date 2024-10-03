package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Vacunacion implements Servicio {

	private Medico medico;
	private Mascota mascota;
	private String nombreVacuna;
	private double costo;
	private int materialesDescartables;
	private LocalDate fechaVacunacion;
	
	public Vacunacion(Mascota mascota, Medico medico, String nombreVacuna, double costo, int materialesDescartables) {
		this.mascota = mascota;
		this.medico = medico;
		this.nombreVacuna = nombreVacuna;
		this.costo = costo;
		this.materialesDescartables = materialesDescartables;
		this.fechaVacunacion = LocalDate.now();
	}

	@Override
	public double costoServicio() {
		double honorarios = this.medico.getHonorarios();
		double total = honorarios + (this.materialesDescartables * 500) + this.costo;
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
		return this.fechaVacunacion;
	}
	
}
