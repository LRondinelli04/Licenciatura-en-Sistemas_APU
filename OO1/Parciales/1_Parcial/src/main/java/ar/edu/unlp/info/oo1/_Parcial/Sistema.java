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
	 * Dar de alta un contribuyente
	 * 
	 * 
	 * 
	 * BIENES: 
	 * dar de alta un inmueble
	 * 
	 * dar de alta un automotr
	 * 
	 * dar de alta una embarcacion
	 * 
	 * 
	 * --------------
	 * 
	 * 
	 * calcular el impuesto que debe pagar un contribuyente
	 * 
	 * contribuyentes que mas pagan de una localidad
	 * */
	
	/*
	 * el sistema tiene una lista de contribuyentes donde cada contribuyente tiene su bien registrado
	 * */
	
	private List<Contribuyente> contribuyentes;
	
	public Sistema() {
		this.contribuyentes = new ArrayList<Contribuyente>();
	}
	
	public Contribuyente darAltaContribuyente(Contribuyente contribuyente) {
		this.contribuyentes.add(contribuyente);
		return contribuyente;
	}
	
	public Inmueble darAltaInmbueble(int numeroPartida, double valorLote, double valorEdificacion, Contribuyente contribuyente) {
		Inmueble bien = new Inmueble(numeroPartida, valorLote, valorEdificacion, contribuyente);
		contribuyente.registrarBien(bien);
		return bien;
	}
	
	public Automotor darAltaAutomotor(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor, Contribuyente contribuyente) {
		Automotor bien = new Automotor(patente, marca, modelo, fechaFabricacion, valor, contribuyente);
		contribuyente.registrarBien(bien);
		return bien;
	}
	
	public Embarcacion darAltaEmbarcacion(String patente, String nombre, LocalDate fechaFabricacion, double valor, Contribuyente contribuyente) {
		Embarcacion bien = new Embarcacion(patente, nombre, fechaFabricacion, valor, contribuyente);
		contribuyente.registrarBien(bien);
		return bien;
	}
	
	public double impuestoPagarContribuyente(Contribuyente contribuyente) {
		double montoTotal = 0.0;
		for (Contribuyente c : this.contribuyentes) {
			if (c.equals(contribuyente)) {
				montoTotal = c.impuestoAPagar();
			}
		}
		return montoTotal;
	}
	
	public void contribuyentesMasPagan(String localidad, int N) {
	    List<Contribuyente> cMasPagan = this.contribuyentes.stream()
	        // Filtrar contribuyentes por localidad
	        .filter(c -> c.getLocalidad().equals(localidad))
	        // Ordenar por impuesto a pagar de forma descendente
	        .sorted((c1, c2) -> Double.compare(c2.impuestoAPagar(), c1.impuestoAPagar()))
	        // Limitar a N resultados
	        .limit(N)
	        // Recoger los resultados en una lista
	        .collect(Collectors.toList());

	    // Imprimir los nombres de los contribuyentes
	    for (Contribuyente c : cMasPagan) {
	        System.out.println(c.getNombre());
	    }
	}
	
}
