package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class SistemaVeterinaria {

	private List<Mascota> mascotas;
	private List<Medico> medicos;
	
	public SistemaVeterinaria() {
		this.mascotas = new ArrayList<Mascota>();
		this.medicos = new ArrayList<Medico>();
	}
	
	public Medico registrarMedico(String n, LocalDate f, double h) {
		Medico m = new Medico(n, f, h);
		this.medicos.add(m);
		return m;
	}
	
	public Mascota registrarMascota(String n, LocalDate f, String e) {
		Mascota m = new Mascota(n, f, e);
		this.mascotas.add(m);
		return m;
	}
	
	public double montoRecaudacionCachorro(LocalDate fecha) {
		return this.mascotas.stream()
				.filter(m -> Period.between(m.getFechaNacimiento(), LocalDate.now()).getYears() < 2)
				.mapToDouble(m -> m.montoRecaudacion(fecha))
				.sum();
	}

}
