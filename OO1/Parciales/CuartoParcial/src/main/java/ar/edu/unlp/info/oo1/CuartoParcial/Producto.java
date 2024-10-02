package ar.edu.unlp.info.oo1.CuartoParcial;

public abstract class Producto {

	protected String nombre, descripcion;
	protected double costo;
	
	public Producto(String nombre, String descripcion, double costo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	
	/*
	public double getCosto() {
		return this.costo;
	}
	*/
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract double calcularImpuesto(int cant);
	
}
