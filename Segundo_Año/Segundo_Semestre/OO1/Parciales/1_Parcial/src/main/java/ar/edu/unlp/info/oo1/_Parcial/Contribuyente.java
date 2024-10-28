package ar.edu.unlp.info.oo1._Parcial;

import java.util.ArrayList;
import java.util.List;

public class Contribuyente {

	private String nombre, email, localidad;
	private List<Bien> bienes;
	
	public Contribuyente(String nombre, int dni, String email, String localidad) {
		this.nombre = nombre;
		this.email = email;
		this.localidad = localidad;
		this.bienes = new ArrayList<Bien>();
	}
	
	public Bien registrarBien(Bien bien) {
		this.bienes.add(bien);
		return bien;
	}
	
	
	// Calcular el impuesto a pagar por un contribuyente
	public double impuestoAPagar() {
		double monto = 0.0;
		for (Bien bien : this.bienes) {
			monto += bien.calcularImpuesto();
		}
		return monto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getLocalidad() {
		return this.localidad;
	}
	
	public double impuestoPagarContribuyente() {
		return this.bienes.stream().mapToDouble(Bien::calcularImpuesto).sum();
	}
}
