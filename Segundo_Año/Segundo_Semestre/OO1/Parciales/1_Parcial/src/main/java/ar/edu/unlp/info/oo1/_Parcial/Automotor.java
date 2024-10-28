package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automotor implements Bien {

	private String patente, marca, modelo;
	private LocalDate fechaFabricacion;
	private double valor;
	private Contribuyente contribuyente;

	public Automotor(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor,
			Contribuyente contribuyente) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaFabricacion = fechaFabricacion;
		this.valor = valor;
		this.contribuyente = contribuyente;
	}

	@Override
	public double calcularImpuesto() {
		double monto = 0.0;
		if (Bien.superaLosDiezAnios(fechaFabricacion)) {
			monto = 0;
		} else {
			monto = this.valor * 0.05;
		}
		return monto;
	}

}
