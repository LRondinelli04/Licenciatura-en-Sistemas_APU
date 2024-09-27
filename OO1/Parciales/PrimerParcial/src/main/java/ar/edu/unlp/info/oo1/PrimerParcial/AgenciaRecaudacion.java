package ar.edu.unlp.info.oo1.PrimerParcial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgenciaRecaudacion {

	private List<Contribuyente> contribuyentes;

	
	public AgenciaRecaudacion() {
		this.contribuyentes = new ArrayList<Contribuyente>();
	}
	
	// agrego un contribuyente a la lista
	public void agregarContribuyente(Contribuyente contri) {
		this.contribuyentes.add(contri);
	}
	
	// Calculo que contribuyente de la misma localidad paga mas impuesto
	public List<Contribuyente> contribuyenteQueMasPagan(String localidad, int N){
		
		// Filtrar por localidad y ordenar por el contribuyente que mayor impuesto paga
		return this.contribuyentes.stream()
				.filter(c -> c.getLocalidad().equalsIgnoreCase(localidad)) // Filtrar por localidad (equalsIgnoreCase es para un STRING)
				.sorted(Comparator.comparingDouble(Contribuyente::calcularImpuesto).reversed()) // Ordenar de mayor a menor segun el calcularImpuesto
				.limit(N) // limito los primeros N
				.collect(Collectors.toList()); // retorno la lista
	}
	
}
