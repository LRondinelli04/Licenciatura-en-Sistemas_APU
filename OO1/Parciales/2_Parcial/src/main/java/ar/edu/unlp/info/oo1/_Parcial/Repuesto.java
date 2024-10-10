package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;

public class Repuesto {

	private String nombre;
	private LocalDate fechaFabricacion;
	private double costo;
	
	public Repuesto(String nombre, LocalDate fechaFabricacion,double costo) {
		this.nombre = nombre;
		this.fechaFabricacion = fechaFabricacion;
		this.costo = costo;
	}
	
	public double getCosto() {
		return this.costo;
	}
	
	public LocalDate getFechaFabricacion() {
		return this.fechaFabricacion;
	}
	
}
