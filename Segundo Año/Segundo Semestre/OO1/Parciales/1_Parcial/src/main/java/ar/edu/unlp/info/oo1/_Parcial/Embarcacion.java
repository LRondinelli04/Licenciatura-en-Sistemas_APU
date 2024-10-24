package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Embarcacion implements Bien{

	private String patente, nombre;
	private LocalDate fechaFabricacion;
	private double valor;
	private Contribuyente contribuyente;
	
	public Embarcacion(String patente, String nombre, LocalDate fechaFabricacion, double valor, Contribuyente contribuyente) {
		this.patente = patente;
		this.nombre = nombre;
		this.fechaFabricacion = fechaFabricacion;
		this.valor = valor;
		this.contribuyente = contribuyente;
	}

	@Override
	public double calcularImpuesto() {
		double monto = 0.0;
		if (this.superaLosDiezAnios()) {
			monto = 0;
		} else {
			if (this.valor < 1000000) {
				monto = this.valor * 0.1;
			} else {
				monto = this.valor * 0.15;
			}
		}
		return monto;
	}
	
	public boolean superaLosDiezAnios() {
		int tiempo = (int) ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now());
		if (tiempo > 10) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
