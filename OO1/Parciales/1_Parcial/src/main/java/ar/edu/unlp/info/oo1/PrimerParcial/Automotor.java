package ar.edu.unlp.info.oo1.PrimerParcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automotor implements Bien {

	private String patente, marca, modelo;
	private LocalDate fecha;
	private double valor;
	
	
	
	public Automotor(String patente, String marca, String modelo, LocalDate fecha, double valor) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.fecha = fecha;
		this.valor = valor;
	}

	@Override
	public double calcularImpuesto() {
		long anios = ChronoUnit.YEARS.between(this.fechaFabricacion(), LocalDate.now());
		double total = 0.0;
		
		if (anios < 10) {
			total += (this.valor * 0.05);
		}
		return total;
	}

	@Override
	public LocalDate fechaFabricacion() {
		return this.fecha;
	}

	

}
