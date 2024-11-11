package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.LocalDate;

public class Vacunacion extends Servicio {

	private Medico medico;
	private String nombreVacuna;
	private double costo;
	private LocalDate fechaAtencion;
	
	public Vacunacion(Mascota mascota, Medico medico, LocalDate fechaAtencion, String nombreVacuna, double costo) {
		super(mascota, LocalDate.now());
		this.medico = medico;
		this.nombreVacuna = nombreVacuna;
		this.costo = costo;
		this.fechaAtencion = fechaAtencion;
	}

	@Override
	public double costoServicio() {
		double total = this.medico.getHonorarios() + this.costo;
		if (super.getFechaAtencion(this.fechaAtencion)) {
			total += 200;
		}
		return total;
	}

}
