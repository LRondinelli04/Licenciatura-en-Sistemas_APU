package ar.edu.unlp.info.oo1.ParcialAgenciaRecaudacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Agencia {

	private List<Contribuyente> contribuyentes;
	
	public Agencia() {
		this.contribuyentes = new ArrayList<Contribuyente>();
	}

	public Contribuyente darAltaContribuyente(String n, int d, String e, String l) {
		Contribuyente c = new Contribuyente(n, d, e, l);
		this.contribuyentes.add(c);
		return c;
	}
	
	public List<Contribuyente> contribuyentesQueMasPagan(String l, int n) {
		return this.contribuyentes.stream()
				.filter(c -> c.getLocalidad().equals(l))
				.sorted((c1, c2) -> Double.compare(c2.impuestoAPagar(), c1.impuestoAPagar()))
				.limit(n)
				.collect(Collectors.toList());
	}
	
}
