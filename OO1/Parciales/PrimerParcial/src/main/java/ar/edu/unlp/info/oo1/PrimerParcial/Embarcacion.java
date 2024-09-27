package ar.edu.unlp.info.oo1.PrimerParcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Embarcacion implements Bien {
	
	private String patente, nombre;
	private LocalDate fecha;
	private double valor;

	public Embarcacion(String patente, String nombre, LocalDate fecha, double valor) {
		this.patente = patente;
		this.nombre = nombre;
		this.fecha = fecha;
		this.valor = valor;
	}

	@Override
	public double calcularImpuesto() {
		// Calculo la diferencia de años
		long anios = ChronoUnit.YEARS.between(this.fechaFabricacion(), LocalDate.now());
		double total = 0;
		
		if (anios < 10) {
			if (this.valor < 1000000) {
				total += (this.valor * 0.15);
			} else {
				total += (this.valor * 0.10);
			}
		}
		return total;
	}

	@Override
	public LocalDate fechaFabricacion() {
		return this.fecha;
	}

	

}
