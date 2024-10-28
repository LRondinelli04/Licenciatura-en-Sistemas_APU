package ar.edu.unlp.info.oo1._Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Sistema {

	/*
	 *
	 *  Hacer un sistema para el calculo de impuesto que debem pagar los contribuyentes
	 *  
	 *  
	 *  el sistema debe:
	 *  	
	 *  
	 *  	dar de alta un contribuyente
	 *  
	 *  	dar de alta un BIEN
	 *  		
	 *  		- inmueble
	 *  		- automotor
	 *  		- embarcacion
	 *  
	 *  	calcular el impuesto que debe pagar un contribuyente
	 *  
	 *  	contribuyentes que mas pagan de una localidad
	 */
	
	private List<Contribuyente> contribuyentes;
	
	public Sistema() {
		this.contribuyentes = new ArrayList<Contribuyente>();
	}
	
	public Contribuyente darAltaContribuyente(String nombre, int dni, String email, String localidad) {
		Contribuyente c = new Contribuyente(nombre, dni, email, localidad);
		this.contribuyentes.add(c);
		return c;
	}
	
	public List<Contribuyente> contribuyentesMasPagan(String localidad, int n){
		// Tomo los contribuyentes de 1 zona especifica
		List<Contribuyente> contribuyentesLocalidad = 	this.contribuyentes.stream()
														.filter(contribuyente -> contribuyente.getLocalidad().equals(localidad))
														.collect(Collectors.toList());
		
		// retorno los n contribuyentes de esa zona que mas pagan
		return 	contribuyentesLocalidad.stream()
				.sorted((c1, c2) -> Double.compare(c2.impuestoAPagar(), c1.impuestoAPagar()))
				.limit(n)
				.collect(Collectors.toList());
	}
	
	
}	
