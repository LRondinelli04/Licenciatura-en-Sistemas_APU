package ar.edu.unlp.info.oo1.SegundoParcial;

public class Empleado {

	private double valorHora;
	private String nombreCompleto;
	
	public Empleado(String nombreCompleto, double valorHora) {
		this.nombreCompleto = nombreCompleto;
		this.valorHora = valorHora;
	}
	
	public double getValorHora() {
		return this.valorHora;
	}
	
}
