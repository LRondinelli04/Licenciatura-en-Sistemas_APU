package ar.edu.unlp.info.oo1.Ej19_ServicioDeEnviosDePaquetes;

import java.time.LocalDate;

public abstract class Envio {

	protected LocalDate fechaDespeacho;
	protected String direccionOrigen, direccionDestino;
	protected double peso;
	
	public Envio(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso) {
		this.fechaDespeacho = fechaDespacho;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}
	
	public LocalDate getFechaDespacho() {
		return this.fechaDespeacho;
	}
	
	public abstract double calcularEnvio();
	
}
