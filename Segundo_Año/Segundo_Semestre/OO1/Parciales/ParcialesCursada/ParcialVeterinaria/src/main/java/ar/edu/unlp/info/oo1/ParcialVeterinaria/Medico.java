package ar.edu.unlp.info.oo1.ParcialVeterinaria;

import java.time.LocalDate;
import java.time.Period;

public class Medico {

	private String nombre;
	private LocalDate fechaIngreso;
	private double honorarios;
	
	public Medico(String n, LocalDate f, double h) {
		this.nombre = n;
		this.fechaIngreso = f;
		this.honorarios = h;
	}
	
	public double getHonorarios() {
		return this.honorarios;
	}
	
	public int getAntiguedad() {
		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}
	
}
