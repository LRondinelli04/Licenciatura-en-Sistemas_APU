package ar.edu.unlp.info.oo1.Ej17_AlquilerDePropiedades;

import java.time.LocalDate;

public class Propiedad {

	private String direccion, nombre;
	private double precioPorNoche;
	private LocalDate fechaInicio, fechaFin;
	private boolean ocupada;
	
	public Propiedad(String direccion, String nombre, double precioPorNoche, LocalDate fechaInicio, LocalDate fechaFin) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.ocupada = false;
	}
	
	public boolean getOcupada() {
		return this.ocupada;
	}
	
	public void ocuparPropiedad() {
		this.ocupada = true;
	}
	
	public void desocuparPropiedad() {
		this.ocupada = false;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
