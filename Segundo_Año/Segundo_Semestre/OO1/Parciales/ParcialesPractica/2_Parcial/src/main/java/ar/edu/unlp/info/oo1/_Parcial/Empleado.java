package ar.edu.unlp.info.oo1._Parcial;

public class Empleado {

	private String nombreCompleto;
	private double valorXHora;
	
	public Empleado(String nombreCompleto, double valorXHora) {
		this.nombreCompleto = nombreCompleto;
		this.valorXHora = valorXHora;
	}
	
	
	public double getValorXHora() {
		return this.valorXHora;
	}
}
