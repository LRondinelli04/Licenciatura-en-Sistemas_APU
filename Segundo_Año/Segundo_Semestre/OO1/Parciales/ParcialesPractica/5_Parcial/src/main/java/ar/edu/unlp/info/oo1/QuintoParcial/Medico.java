package ar.edu.unlp.info.oo1.QuintoParcial;

import java.time.LocalDate;

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
	
	public LocalDate getFechaIngreso() {
		return this.fechaIngreso;
	}
	
	public int getAntiguedad() {
		return LocalDate.now().getYear() - this.fechaIngreso.getYear();
	}
	
}
