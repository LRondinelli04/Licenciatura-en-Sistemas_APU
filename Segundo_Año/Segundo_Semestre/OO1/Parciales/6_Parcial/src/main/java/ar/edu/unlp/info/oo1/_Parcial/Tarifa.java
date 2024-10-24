package ar.edu.unlp.info.oo1._Parcial;

public class Tarifa {

	private double precioUnidadCliente, precioUnidadIndustria;

	public Tarifa(double precioUnidadCliente, double precioUnidadIndustria) {
		this.precioUnidadCliente = precioUnidadCliente;
		this.precioUnidadIndustria = precioUnidadIndustria;
	}
	
	public void actualizarTarifario(double precioUnidadCliente, double precioUnidadIndustria) {
		this.precioUnidadCliente = precioUnidadCliente;
		this.precioUnidadIndustria = precioUnidadIndustria;
	}
	
	public double getPrecioUnidadCliente() {
		return this.precioUnidadCliente;
	}
	
	public double getPrecioUnidadIndustria() {
		return this.precioUnidadIndustria;
	}
	
}
