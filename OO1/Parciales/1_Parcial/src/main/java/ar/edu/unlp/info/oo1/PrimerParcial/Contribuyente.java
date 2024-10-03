package ar.edu.unlp.info.oo1.PrimerParcial;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Contribuyente {

	private String nombre, email, localidad;
	private int dni;
	private List<Bien> bienes;
	
	public Contribuyente(String nombre, int dni, String email, String localidad) {
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.localidad = localidad;
		this.bienes = new ArrayList<Bien>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarBien(Bien bien) {
		this.bienes.add(bien);
	}
	
	/*
	public void mostrarBienes() {
		for (Bien bien : this.bienes) {
			System.out.println("Bienes: " + bien.toString());
		}
	}
	*/
	
	
	/* Calucalar el total de impuesto que debe pagar el contribuyenye
	   Cada bien = 1% del valor de cu
	   Valor de cu = valorLote + valorEdificacion
	*/
	public double calcularImpuesto() {
	    double total = 0.0;
	    for (Bien bien : this.bienes) {
	        double impuestoBien = bien.calcularImpuesto();
	        total += impuestoBien;
	    }
	    return total;
	}
	
	public String getLocalidad() {
		return this.localidad;
	}

}
