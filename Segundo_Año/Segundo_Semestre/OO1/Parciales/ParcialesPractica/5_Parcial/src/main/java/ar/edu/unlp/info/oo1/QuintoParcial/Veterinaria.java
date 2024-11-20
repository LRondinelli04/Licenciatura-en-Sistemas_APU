package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Veterinaria {

	private List<Mascota> mascotas;
	private List<Medico> medicos;
	
	public Veterinaria() {
		this.mascotas = new ArrayList<Mascota>();
		this.medicos = new ArrayList<Medico>();
	}
	
	public Mascota registrarMascota(Mascota mascota) {
		this.mascotas.add(mascota);
		return mascota;
	}
	
	public Medico registrarMedico(Medico medico) {
		this.medicos.add(medico);
		return medico;
	}
	
	public double recaudacionCachorros(LocalDate fecha) {
		double total = 0.0;
		// recorro la lista de mascotas
		for (Mascota mascota : this.mascotas) {
			// tomo las mascotas menores a 2 años
			if (Period.between(mascota.getNacimiento(), LocalDate.now()).getYears() < 2) {
				// guardo lo recaudado por las mascotas menores que coincidan con esa fecha
				total += mascota.montoGeneradoMascota(fecha);
			}
		}
		return total;
	}
	
	public int getCantMascotas() {
		return this.mascotas.size();
	}
	
	public int getCantMedicos() {
		return this.medicos.size();
	}

}
