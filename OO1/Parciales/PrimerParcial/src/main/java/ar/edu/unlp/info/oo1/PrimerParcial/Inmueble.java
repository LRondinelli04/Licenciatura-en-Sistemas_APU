package ar.edu.unlp.info.oo1.PrimerParcial;

import java.time.LocalDate;

public class Inmueble implements Bien {

	private int numPartida;
	private double valorLote, valorEdificacion;
	
	public Inmueble(int numPartida, double valorLote, double valorEdificacion) {
		this.numPartida = numPartida;
		this.valorLote = valorLote;
		this.valorEdificacion = valorEdificacion;
	}
	
	@Override
	public double calcularImpuesto() {
		// retorno el 1% del bien
		return (this.valorEdificacion + this.valorLote) * 0.01;
	}

	@Override
	public LocalDate fechaFabricacion() {
		return LocalDate.now();
	}

	
	
	

}
