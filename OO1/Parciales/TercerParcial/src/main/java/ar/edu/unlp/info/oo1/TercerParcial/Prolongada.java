package ar.edu.unlp.info.oo1.TercerParcial;

import java.time.LocalDate;

public class Prolongada extends Contratacion {

	private int cantDias;
	
	
	public Prolongada(Cliente cliente, Servicio servicio, LocalDate fecha, int cantDias) {
		super(cliente, servicio, fecha);
		this.cantDias = cantDias;
	}
	
	public double obtenerMonto() {
		double monto = super.servicio.calcularMonto() * this.cantDias;
		
		if (this.cantDias > 5) {
			double descuento = monto * 0.1;
			monto -= descuento;
		}
		
		return monto;
	}

}
