package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ConsultaMedica extends Servicio {

	private Medico medico;
	private LocalDate fechaAtencion;
	
	public ConsultaMedica(Mascota mascota, Medico medico, LocalDate fechaAtencion) {
		super(mascota, LocalDate.now());
		this.medico = medico;
		this.fechaAtencion = fechaAtencion;
	}

	@Override
	public double costoServicio() {
		double total = this.medico.getHonorarios() + (this.medico.getAntiguedad() * 100);
		if (super.getFechaAtencion(fechaAtencion)) {
			total += 200;
		}
		return total;
	}
	
}
