package ar.edu.unlp.info.oo1.Ej25_Veterinaria;

import java.time.LocalDate;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Medico {

	private String nombre;
	private LocalDate fechaIngreso;
	private double honorarios;
	
	public Medico(String nombre, LocalDate fechaIngreso, double honorarios) {
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.honorarios = honorarios;
	}
	
	public double getHonorarios() {
		return this.honorarios;
	}
	
	public int getAntiguedad() {
		int anio = LocalDate.now().getYear() - this.fechaIngreso.getYear();
		return anio;
	}

}
