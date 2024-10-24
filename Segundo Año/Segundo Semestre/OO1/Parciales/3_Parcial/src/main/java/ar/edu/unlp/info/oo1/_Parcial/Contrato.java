package ar.edu.unlp.info.oo1._Parcial;

public abstract class Contrato {

	protected Cliente cliente;
	protected Servicio servicio;
	
	public Contrato(Cliente cliente, Servicio servicio) {
		this.cliente = cliente;
		this.servicio = servicio;
	}
	
	/*
	 * Metodo para obtener el monto a pagar por un cliente
	 * */
	
	public abstract double calcularMonto();
	
}
