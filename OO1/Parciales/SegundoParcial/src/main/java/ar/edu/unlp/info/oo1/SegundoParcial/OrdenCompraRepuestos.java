package ar.edu.unlp.info.oo1.SegundoParcial;

import java.util.List;

public class OrdenCompraRepuestos {

	private String patente;
	private List<Repuesto> listaRepuesto;
	
	public OrdenCompraRepuestos(String patente, List<Repuesto> listaRepuesto) {
		this.patente = patente;
		this.listaRepuesto = listaRepuesto;
	}
	
	
	public double costoTotal() {
		double costoRepuesto = 0.0;
		double costoFinal = 0.0;
		// Sumar el valor de todos los costos de los repuestos registrados
		for(Repuesto repuesto : this.listaRepuesto) {
			costoRepuesto += repuesto.getCosto();
			
			if (repuesto.tieneMasDeCincoAnios()) {
				costoRepuesto += (costoRepuesto * 0.08);
			} else {
				costoRepuesto += (costoRepuesto * 0.15);
			}
			
			costoFinal += costoRepuesto;
			costoRepuesto = 0.0;
		}
		
		return costoFinal;
	
	}
	
	public double getCostoTotal() {
		return this.costoTotal();
	}
	
	public String getPatente() {
		return this.patente;
	}
	
}
